package com.renewableenergy.SGS;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Battary;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BattaryService {

    @Autowired
    private final BattaryRepository battaryRepository;

    public BattaryService(BattaryRepository battaryRepository) {
        super();
        this.battaryRepository = battaryRepository;
    }

     public List<Battary> list() {
            return battaryRepository.findAll();
        }

     public Battary addNewBattary (Battary battary) {
        return battaryRepository.save(battary);

     }
     public int anzBattary() {
         return (int) battaryRepository.count();

     }

     public Battary deletBattary(long id) {
         return battaryRepository.deletBattaryById(id);

     }

     public Battary updateBattary(Battary battary) {
         return battaryRepository.save(battary);

     }
    public Battary findBattaryByIdid(Long id) {

        return battaryRepository.findBattaryById(id);
    }
}
