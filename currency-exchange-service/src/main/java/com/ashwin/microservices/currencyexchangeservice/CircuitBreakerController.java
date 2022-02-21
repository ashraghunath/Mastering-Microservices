package com.ashwin.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name="default") //default means it retries thrice and if it fails all 3 times it returns exception
//    @Retry(name="sample-api", fallbackMethod = "hardcodedResponse") // gets value from property file
//    @CircuitBreaker(name="sample-api", fallbackMethod = "hardcodedResponse")
    @Bulkhead(name = "sample-api")
    @RateLimiter(name="default")
    public String sampleApi()
    {
//        logger.info("sample-api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/willfail", String.class);
//        return forEntity.getBody();
        return "sample";
    }

    public String hardcodedResponse(Exception ex)
    {
        return "hardcodedResponse";
    }

}
