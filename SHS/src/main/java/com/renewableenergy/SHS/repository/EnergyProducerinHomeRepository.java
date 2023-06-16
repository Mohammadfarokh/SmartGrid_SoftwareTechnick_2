package com.renewableenergy.SHS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
@Repository
public interface EnergyProducerinHomeRepository extends JpaRepository<EnergyProducerinHome, Integer>{

}
