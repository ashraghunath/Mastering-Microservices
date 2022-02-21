package com.ashwin.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

    //Spring data JPA converts following to SQL query
    CurrencyExchange findByFromAndTo(String from, String to);

}
