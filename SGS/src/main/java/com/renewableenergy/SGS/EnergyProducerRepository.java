package com.renewableenergy.SGS;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renewableenergy.SGS.entity.EnergyProducer;

public interface EnergyProducerRepository extends JpaRepository<EnergyProducer,Long> {

}
