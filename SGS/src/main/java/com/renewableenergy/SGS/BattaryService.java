package com.renewableenergy.SGS;
import java.util.List;


import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Battary;
@Service
public class BattaryService {

	private final BattaryRepository battaryRepository;

	public BattaryService(BattaryRepository battaryRepository) {
		super();
		this.battaryRepository = battaryRepository;
	}
	
	 public List<Battary> list() {
	        return battaryRepository.findAll();
	    }
	 
	 public boolean addNewBattary (Battary battary) {
		 battaryRepository.save(battary);
		 return true;
	 }
	 public int anzBattary() {
		 return (int) battaryRepository.count();
		  
	 }
}
