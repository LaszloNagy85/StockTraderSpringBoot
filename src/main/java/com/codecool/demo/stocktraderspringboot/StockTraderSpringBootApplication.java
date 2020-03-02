package com.codecool.demo.stocktraderspringboot;

import com.codecool.demo.stocktraderspringboot.service.TradingApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StockTraderSpringBootApplication {

    @Autowired
    private TradingApp tradingApp;

    public static void main(String[] args) {
        SpringApplication.run(StockTraderSpringBootApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        tradingApp.start();

    }
}
