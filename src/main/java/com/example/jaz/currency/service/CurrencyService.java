package com.example.jaz.currency.service;

import com.example.jaz.currency.model.CurrencyTable;
import com.example.jaz.currency.model.Rate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.OptionalDouble;

@Service
public class CurrencyService {

    String apiUrl = "http://api.nbp.pl/api/";

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OptionalDouble getCurrencyRatesAverage(String currency, String startDate, String endDate) {
        CurrencyTable currencyTable = restTemplate
                .getForEntity(this.apiUrl + "exchangerates/rates/A/" + currency + "/" + startDate + "/" + endDate + "/", CurrencyTable.class)
                .getBody();

        return currencyTable.getRates().stream().mapToDouble(Rate::getMid).average();
    }
}
