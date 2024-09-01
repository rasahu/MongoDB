package com.example.cogni.monogoDB.services;

import com.example.cogni.monogoDB.entity.OlympicMedals;
import com.example.cogni.monogoDB.repository.OlympicMedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OlympicMedalServices {

    @Autowired
    private OlympicMedalRepository olympicMedalRepository;

    public List<OlympicMedals> getMedalTally(){
        return  olympicMedalRepository.findAll();
    }
    public void saveMedalTally(OlympicMedals OlympicMedals){
          olympicMedalRepository.save(OlympicMedals);
    }
}
