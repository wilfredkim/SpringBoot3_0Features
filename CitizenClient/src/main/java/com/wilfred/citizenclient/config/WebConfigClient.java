package com.wilfred.citizenclient.config;

import com.wilfred.citizenclient.service.CitizenClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@Slf4j
public class WebConfigClient {
    private final String CITIZEN_SERVER_BASE_URL = "http://localhost:1020";

    @Bean
    public WebClient citizenClientWebClient() {
        return WebClient.builder().baseUrl(CITIZEN_SERVER_BASE_URL).build();
    }

    @Bean
    public CitizenClientService citizenClientService() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(citizenClientWebClient())).build();
        log.info("CitizenClientService>>>>>>>>>>>>");
        return httpServiceProxyFactory.createClient(CitizenClientService.class);
    }
}
