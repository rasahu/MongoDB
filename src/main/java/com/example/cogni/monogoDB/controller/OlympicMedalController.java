package com.example.cogni.monogoDB.controller;


import com.example.cogni.monogoDB.entity.OlympicMedals;
import com.example.cogni.monogoDB.model.GeneralResponse;
import com.example.cogni.monogoDB.services.OlympicMedalServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/olympicMedal")
public class OlympicMedalController {

    private static final String ID = "/{id}";
    @Autowired
    private OlympicMedalServices olympicMedalServices;


    @GetMapping("/getMedalTally")
    public ResponseEntity<List<OlympicMedals>> getAllMedalList() {
        return new ResponseEntity<>(olympicMedalServices.getMedalTally(), HttpStatus.OK);
    }

    @PostMapping("/saveMedalTally")
    public ResponseEntity<GeneralResponse> saveMedal(@Valid @RequestBody OlympicMedals olympicMedals) {
        GeneralResponse response = new GeneralResponse();
        olympicMedalServices.saveMedalTally(olympicMedals);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Medal has been save successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateMedalTally" + ID)
    public ResponseEntity<GeneralResponse> updateMadel(@Validated @RequestBody OlympicMedals olympicMedals) {
        return new ResponseEntity<>(olympicMedalServices.saveMedalTally(olympicMedals), HttpStatus.OK);
    }
}
