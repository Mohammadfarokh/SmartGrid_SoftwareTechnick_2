package com.renewableenergy.SGS;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renewableenergy.SGS.entity.SmartGrid;

public interface BattaryRepository extends JpaRepository<SmartGrid,Long> {

}
