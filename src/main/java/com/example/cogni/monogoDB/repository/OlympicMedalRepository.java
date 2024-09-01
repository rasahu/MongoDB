package com.example.cogni.monogoDB.repository;

import com.example.cogni.monogoDB.entity.OlympicMedals;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OlympicMedalRepository extends MongoRepository<OlympicMedals,Integer> {

}
