package com.example.cogni.monogoDB.services;

import com.example.cogni.monogoDB.entity.OlympicMedals;
import com.example.cogni.monogoDB.repository.OlympicMedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OlympicMedalServices {

    @Autowired
    private OlympicMedalRepository olympicMedalRepository;

    public List<OlympicMedals> getMedalTally() {
        List<OlympicMedals> medalsList = olympicMedalRepository.findAll().stream().unordered().toList();

        medalsList = medalsList.stream().sorted(Comparator.comparing(OlympicMedals::getGold)
                        .thenComparing(Comparator.comparing(OlympicMedals::getSilver))
                        .thenComparing(Comparator.comparing(OlympicMedals::getBronze)).reversed())
                .collect(Collectors.toList());

/*        .stream().toList().stream().map(medal->medal.setTotalMedal(
                medal.getGold()+medal.getSilver()+medal.getBronze())).collect(Collectors.toList());*/
        return medalsList;
    }

    public void saveMedalTally(OlympicMedals OlympicMedals) {
        olympicMedalRepository.save(OlympicMedals);
    }
}
