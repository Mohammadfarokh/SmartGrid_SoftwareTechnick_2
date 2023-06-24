package com.renewableenergy.SGS.controlers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homePageDTOs.homePageData;
import homePageDTOs.solarPanelData;
//home controller gibt mir die Daten von Database die infos an frontend
//@ A-notiation rest controller nimmt json 
//
@RestController
// request soll an der Url hier 
@RequestMapping(value = "api/v1/home")
public class HomeController {
	//alle request api/v1/home 
	@GetMapping
	//* configuration für die Data ist wichtig für die crossside, value=localhost oder * allow all  
	@CrossOrigin("*") 
	public homePageData function() {
		solarPanelData s1=new solarPanelData("lala",20,92,true);
		solarPanelData s2=new solarPanelData("lalala",20,92,true);
		homePageData h1=new homePageData();
		
		h1.solarPanelArray.add(s1);
		h1.solarPanelArray.add(s2);
		return h1;
	}
	
	//api/v1/home/h2
	@GetMapping("h2")
	public String function2() {
		return "hello";
	}
}
