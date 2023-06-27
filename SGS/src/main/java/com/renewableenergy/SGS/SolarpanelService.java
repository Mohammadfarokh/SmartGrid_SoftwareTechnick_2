package com.renewableenergy.SGS;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Solarpanel;
import com.renewableenergy.SGS.entity.Turbine;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SolarpanelService {

	@Autowired
	private final SolarpanelRepository solarpanelRepository;
	SolarpanelService(SolarpanelRepository solarpanelRepository) {
		this.solarpanelRepository = solarpanelRepository;
	}
	
	public Solarpanel addSolarpanel (Solarpanel solarpanel) {
		return solarpanelRepository.save(solarpanel);
	}
	
	public List<Solarpanel> findAllSolarpanel(){
		return solarpanelRepository.findAll();
	}
	
	public Solarpanel updateSolarpanel(Solarpanel solarpanel) {
		return solarpanelRepository.save(solarpanel);
	}
	
	public Solarpanel findSolarpanelByIdid(Long id ) {

		return solarpanelRepository.findSolarpanelById(id);
		
	}
	
	public void deleteTurbine (Long id) {
		solarpanelRepository.deleteSolarpanelById(id);
	}
}
