package com.renewableenergy.SHS.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.ShsApplication;
import com.renewableenergy.SHS.DTO.HomeBattaryDTO;
import com.renewableenergy.SHS.DTO.SmartHomeDTO;
import com.renewableenergy.SHS.DTO.SmartMeterDTO;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.service.HomeBattaryService;
import com.renewableenergy.SHS.service.SmartHomeService;
import com.renewableenergy.SHS.service.SmartMeterService;

@RestController
@RequestMapping(value = "api/v1/smart-meter")
public class SmartMeterController {
	public final SmartMeterService sms;
	public final SmartHomeService shs;
	@Autowired
	SmartMeterController(SmartMeterService sms, SmartHomeService shs){
		this.sms = sms;
		this.shs = shs;
	}
	
	@PostMapping(value = "/smart-meter-add")
	@CrossOrigin("*") 
	public boolean addSmartMeter(@RequestBody SmartMeter request) {
		//you have to check for adding Exception
		try {
			sms.addSmartMeter(request.getName(), request.getProducedEnergy(),
					request.getConsumedEnergyWithTariff(), request.getConsumedEnergyWithoutTariff());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	
	@GetMapping(value = "/smart-meter-show")
	@CrossOrigin("*") 
	public List<SmartMeter> getSmartMeter(){
		LinkedList <SmartMeter> smlist = new LinkedList<SmartMeter>();
		for(SmartMeter s : smlist) {
//			s.setConsumedEnergyWithoutTariff(ShsApplication.consumedEnergyWithoutTariff);
//			s.setConsumedEnergyWithTariff(ShsApplication.consumedEnergyWithTariff);
//			s.setProducedEnergy(ShsApplication.producedEnergy);
			s.notifyme();
			System.out.println("done");
			sms.update(s);
		}
		
		return sms.getSmartMeter();
	}
	 @PutMapping("/smart-meter-update")
	 @CrossOrigin("*") 
	  public boolean updateSmartMeter(@RequestBody SmartMeter request){
		 try {
			 	sms.update(request);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
	  }
	@PostMapping(value = "/smart-meter-remove")
	public boolean removeSmartMeter(@RequestBody SmartMeter request) {
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
