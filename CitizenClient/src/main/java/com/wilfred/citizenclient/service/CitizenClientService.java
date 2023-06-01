package com.wilfred.citizenclient.service;

import com.wilfred.citizenclient.model.Citizen;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/api/v1/citizens")
public interface CitizenClientService {
    @GetExchange
     List<Citizen> getList();
}
