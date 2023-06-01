package com.wilfred.citizenserver.controller;


import com.wilfred.citizenserver.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wilfred.citizenserver.service.CitizenService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citizens")
public class CitizenController {
    @Autowired
    CitizenService citizenService;

    @PostMapping
    public Citizen addStudent(@RequestBody Citizen citizen) {
        return citizenService.addCitizen(citizen);
    }

    @GetMapping
    public List<Citizen> getList() {
        return citizenService.getCitizenList();
    }

    @GetMapping("/{id}")
    public Citizen findById(@PathVariable Long id) {
        return citizenService.findById(id);
    }
}
