package com.renewableenergy.SHS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renewableenergy.SHS.entity.SmartHome;
@Repository
public interface SmartHomeRepository extends JpaRepository<SmartHome, Integer>{

}
