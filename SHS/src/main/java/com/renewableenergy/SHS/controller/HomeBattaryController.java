package com.renewableenergy.SHS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.DTO.EnergyProducerinHomeDTO;
import com.renewableenergy.SHS.DTO.HomeBattaryDTO;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.service.HomeBattaryService;
import com.renewableenergy.SHS.service.HomeSolarPanel;
import com.renewableenergy.SHS.service.HomeTurbine;
@RestController
@RequestMapping(value = "api/v1/home-battary")
public class HomeBattaryController {
		public final HomeBattaryService hb;
		@Autowired
		HomeBattaryController(HomeBattaryService hb){
			this.hb = hb;
		}
		
		@PostMapping(value = "/home-battary-add")
		public boolean addHomeBattary(@RequestBody HomeBattaryDTO request) {
			//you have to check for adding Exception
			try {
				hb.addHomeBattary(request.getName(), request.getMaxCapacity() );
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
		}
		@GetMapping(value = "/home-battary-show")
		public List<HomeBattary> getSolarPanel(){
			return hb.getBattary();
		}
}

