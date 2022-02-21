package com.ashwin.microservices.currencyconversionmicroservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Proxy class to call currency exchange service
//typically give the name specified in application props of the class being called
//@FeignClient(name="currency-exchange",url = "localhost:8000") //If eureka is not configured
@FeignClient(name="currency-exchange") // if eureka is configured feign talked to eureka and picks up and instance and
//does the load balancing
public interface CurrencyExchangeProxy {

    //same as controller in Currency exchange service but mapped to CurrencyConversion since it has similar structure
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
