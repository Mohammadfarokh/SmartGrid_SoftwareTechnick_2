package com.renewableenergy.SGS;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renewableenergy.SGS.entity.Solarpanel;

public interface SolarpanelRepository extends JpaRepository<Solarpanel,Long> {

	void deleteSolarpanelById(Long id);
	Solarpanel findSolarpanelById(Long id);
}
