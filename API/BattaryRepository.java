package com.renewableenergy.SGS;

import org.springframework.data.jpa.repository.JpaRepository;


import com.renewableenergy.SGS.entity.Battary;

public interface BattaryRepository extends JpaRepository<Battary,Long> {

    Battary findBattaryById(long id);
    Battary deletBattaryById(long id);



}
