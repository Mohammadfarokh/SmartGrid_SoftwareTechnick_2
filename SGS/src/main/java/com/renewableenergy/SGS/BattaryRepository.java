package com.renewableenergy.SGS;

import org.springframework.data.jpa.repository.JpaRepository;


import com.renewableenergy.SGS.entity.Battary;
import com.renewableenergy.SGS.entity.Solarpanel;

public interface BattaryRepository extends JpaRepository<Battary,Long> {
	
	void deleteBattaryById(Long id);
	Battary findBattaryById(Long id);

}
