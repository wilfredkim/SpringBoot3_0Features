package com.wilfred.citizenclient.controller;

import com.wilfred.citizenclient.model.Citizen;
import com.wilfred.citizenclient.service.CitizenClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/citizen")
@Slf4j
public class CitizenClientController {
    @Autowired
    private CitizenClientService citizenClientService;

    @GetMapping
    public List<Citizen> getList() {
        log.info("Citizen Client :::::::::::::;");
        return citizenClientService.getList();
    }

}
