package com.renewableenergy.SGS;

import java.util.List;

import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Battary;
import com.renewableenergy.SGS.entity.SmartGrid;

@Service
public class SmartGridService {
	
	
	private final SmartGridRepository smartGridRepository;
	
	public SmartGridService(SmartGridRepository smartGridRepository) {
        this.smartGridRepository = smartGridRepository;
    }
	
	// private List<SmartGrid> smartGridList = new ArrayList<>();
	
	
	 public List<SmartGrid> list() {
	        return smartGridRepository.findAll();
	    }
	 
	 public void printlist() {
		 list().forEach(System.out::println);

	    }
	

}
