package com.example.cogni.monogoDB.controller;


import com.example.cogni.monogoDB.entity.OlympicMedals;
import com.example.cogni.monogoDB.services.OlympicMedalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/olympicMedal")
public class OlympicMedalController {
    @Autowired
    private OlympicMedalServices olympicMedalServices;

    @GetMapping("/getMedalTally")
    public ResponseEntity<List<OlympicMedals>> getAllMedalList(){
        return new ResponseEntity<>(olympicMedalServices.getMedalTally(), HttpStatus.OK);
    }
    @PostMapping("/saveMedalTally")
    public ResponseEntity<List<OlympicMedals>> saveMedal(@RequestParam  ){
        return new ResponseEntity<>(olympicMedalServices.getMedalTally(), HttpStatus.OK);
    }
}
