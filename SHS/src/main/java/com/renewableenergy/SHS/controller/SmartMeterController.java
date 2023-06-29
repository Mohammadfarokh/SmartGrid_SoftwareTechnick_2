package com.renewableenergy.SHS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.renewableenergy.SHS.DTO.HomeBattaryDTO;
import com.renewableenergy.SHS.DTO.SmartHomeDTO;
import com.renewableenergy.SHS.DTO.SmartMeterDTO;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.service.HomeBattaryService;
import com.renewableenergy.SHS.service.SmartMeterService;

@RestController
@RequestMapping(value = "api/v1/smart-meter")
public class SmartMeterController {
	public final SmartMeterService sms;
	@Autowired
	SmartMeterController(SmartMeterService sms){
		this.sms = sms;
	}
	
	@PostMapping(value = "/smart-meter-add")
	public boolean addSmartMeter(@RequestBody SmartMeterDTO request) {
		//you have to check for adding Exception
		try {
			sms.addSmartMeter(request.getId_smartHome(),request.getName(), request.getProducedEnergy(),
					request.getConsumedEnergyWithTariff(), request.getConsumedEnergyWithoutTariff());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@GetMapping(value = "/smart-meter-show")
	public List<SmartMeter> getSmartMeter(){
		return sms.getSmartMeter();
	}
	@PostMapping(value = "/smart-meter-remove")
	public boolean removeSmartMeter(@RequestBody SmartMeterDTO request) {
		//you have to check for adding Exception
		try {
			sms.deleteSmartMeter(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
}
