package com.renewableenergy.SGS;

import java.util.List;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Battary;
import com.renewableenergy.SGS.entity.SmartGrid;

@Service
@Transactional
public class SmartGridService {
	
	@Autowired
	private final SmartGridRepository smartGridRepository;
	
	public SmartGridService(SmartGridRepository smartGridRepository) {
        this.smartGridRepository = smartGridRepository;
    }
	
	public List<SmartGrid> findAllSolarpanel(){
		return smartGridRepository.findAll();
	}
	
	public SmartGrid updateSolarpanel(SmartGrid solarpanel) {
		return smartGridRepository.save(solarpanel);
	}
	

}
