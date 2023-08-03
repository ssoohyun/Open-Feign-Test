package com.arms.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Base64;

public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Value("${cloud.jira.id}")
    public String jiraID;

    @Value("${cloud.jira.pass}")
    public String jiraPass;

    @Bean
    public RequestInterceptor cloudJiraAuthInterceptor() {
        return template -> {
            String authHeader = createBasicAuthHeader(jiraID, jiraPass);
            template.header("Authorization", "Basic " + authHeader);
        };
    }

    private String createBasicAuthHeader(String jiraID, String jiraPass) {
        String auth = jiraID + ":" + jiraPass;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

}
