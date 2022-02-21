package com.ashwin.microservices.limitsservice.controller;

import com.ashwin.microservices.limitsservice.bean.Limits;
import com.ashwin.microservices.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits()
    {
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
