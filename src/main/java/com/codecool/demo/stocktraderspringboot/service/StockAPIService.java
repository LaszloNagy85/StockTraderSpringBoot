package com.codecool.demo.stocktraderspringboot.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Stock price service that gets prices from Yahoo.
 **/
@Service
class StockAPIService {
    private final String apiPath = "https://financialmodelingprep.com/api/v3/stock/real-time-price/%s";

    @Autowired
    private RemoteURLReader remoteURLReader;

    StockAPIService(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }

    StockAPIService() {};

    public void setRemoteURLReader(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }

    /** Get stock price from iex and return as a double
     *  @param symbol Stock symbol, for example "aapl"
     **/
    double getPrice(String symbol) throws IOException, JSONException {
        String url = String.format(apiPath, symbol);
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);
    }

    /** Buys a share of the given stock at the current price. Returns false if the purchase fails */
    boolean buy(String symbol) {
        // Stub. No need to implement this.
        return true;
    }
}