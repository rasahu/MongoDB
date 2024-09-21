package com.example.cogni.monogoDB.services;

import com.example.cogni.monogoDB.entity.OlympicMedals;
import com.example.cogni.monogoDB.model.GeneralResponse;
import com.example.cogni.monogoDB.repository.OlympicMedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class OlympicMedalServices {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private OlympicMedalRepository olympicMedalRepository;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RedisServices redisServices;

    Integer index = 0;

    public List<OlympicMedals> getMedalTally() {
        List<OlympicMedals> medalsList = olympicMedalRepository.findAll().stream().unordered().toList();
        medalsList = medalsList.stream().sorted(Comparator.comparingInt(OlympicMedals::getGold).thenComparing(Comparator.comparingInt(OlympicMedals::getSilver)).thenComparing(Comparator.comparingInt(OlympicMedals::getBronze))).collect(Collectors.toList()).reversed();
        medalsList.forEach((medal) -> {
            medal.setRank(++index);
            medal.setTotalMedal(medal.getGold() + medal.getSilver() + medal.getBronze());
        });
      /*  kafkaTemplate.send("rasahu-topic", "Hi this is Rakesh  Calling  from  producer application.");
        kafkaTemplate.send("rasahu-topic", "getMedlTally", "Hi this is Rakesh  Calling  from  producer application.");*/
/*        .stream().toList().stream().map(medal->medal.setTotalMedal(
                medal.getGold()+medal.getSilver()+medal.getBronze())).collect(Collectors.toList());*/
        return medalsList;

    }

    public GeneralResponse saveMedalTally(@Validated OlympicMedals OlympicMedals) {
        GeneralResponse response = new GeneralResponse();
        olympicMedalRepository.save(OlympicMedals);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Medal has been save successfully.");
        return response;
    }

    public OlympicMedals getMedalInfoByCountryCode(String countyCode) {
        Optional<OlympicMedals> olympicMedalsOptional = Optional.ofNullable(redisServices.get("Medal List  for Country " + countyCode, OlympicMedals.class));
        if (olympicMedalsOptional.isPresent()) {
            return olympicMedalsOptional.get();
        } else {
            Query query = new Query().addCriteria(Criteria.where("countryCode").is(countyCode));
            OlympicMedals olympicMedals = (OlympicMedals) mongoTemplate.findOne(query, OlympicMedals.class);
            redisServices.set("Medal List  for Country " + countyCode, olympicMedals, 1000l);
            return olympicMedals;
        }
    }


    public GeneralResponse updateMedalTally() {
        GeneralResponse response = new GeneralResponse();
        Query query = new Query().addCriteria(Criteria.where("country").is("South Korea"));
        Update updateQuery = new Update().set("countryCode", "KOR");
        mongoTemplate.findAndModify(query, updateQuery, OlympicMedals.class);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Country has been updated Successfully.");
        return response;
    }

    @Scheduled(fixedDelay = 5000) // Update cache every 5 seconds
    public void updateCacheScheduled() {
        System.out.println("Cache updated ::: " + index + String.valueOf(1));
    }
}
