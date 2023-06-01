package com.wilfred.citizenserver.service;


import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import com.wilfred.citizenserver.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenService {
    private List<Citizen> citizenList = new ArrayList<>();

    @Autowired
    private ObservationRegistry observationRegistry;

    public Citizen addCitizen(Citizen citizen) {
        citizenList.add(citizen);
        return Observation.createNotStarted("addCitizen", observationRegistry).observe(() -> citizen);
    }

    public List<Citizen> getCitizenList() {
        return Observation.createNotStarted("getCitizensList", observationRegistry).observe(() -> citizenList);
    }

    public Citizen findById(Long id) {
        return Observation.createNotStarted("getCitizenById", observationRegistry).observe(() ->
                citizenList.stream().filter(citizen -> citizen.id().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Citizen with id " + id + " not found!")));

    }
}
