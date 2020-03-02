package com.codecool.demo.stocktraderspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class TradingApp {

//    Logger logger, Trader trader
    @Autowired
    private Logger logger;

    @Autowired
    private Trader trader;

    public void start() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a stock symbol (for example aapl):");
        String symbol = keyboard.nextLine();
        System.out.println("Enter the maximum price you are willing to pay: ");
        double price;
        try {
            price = keyboard.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Enter a number");
            return;
        }

        try {
            boolean purchased = trader.buy(symbol, price);
            if (purchased) {
                logger.log("Purchased stock!");
            }
            else {
                logger.log("Couldn't buy the stock at that price.");
            }
        } catch (Exception e) {
            logger.log("There was an error while attempting to buy the stock: " + e.getMessage());
        }
    }
}
