package com.example.jaz.currency.service;

import com.example.jaz.currency.model.CurrencyTable;
import com.example.jaz.currency.model.Rate;
import com.example.jaz.currency.model.RateInfo;
import com.example.jaz.currency.repository.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class CurrencyService {

    String apiUrl = "http://api.nbp.pl/api/";

    private final CurrencyRepository currencyRepository;

    private final RestTemplate restTemplate;

    public CurrencyService(CurrencyRepository currencyRepository, RestTemplate restTemplate) {
        this.currencyRepository = currencyRepository;
        this.restTemplate = restTemplate;
    }

    public RateInfo getRateInfo(String currency, String startDate, String endDate) {
        CurrencyTable currencyTable = restTemplate
                .getForEntity(this.apiUrl + "exchangerates/rates/A/" + currency + "/" + startDate + "/" + endDate + "/", CurrencyTable.class)
                .getBody();

        double ratesAverage = currencyTable
                .getRates()
                .stream()
                .mapToDouble(Rate::getMid)
                .average()
                .orElse(-1);

        RateInfo rateInfo = new RateInfo();
        rateInfo.setCurrency(currency);
        rateInfo.setStart_date(startDate);
        rateInfo.setEnd_date(endDate);
        rateInfo.setRate(ratesAverage);
        rateInfo.setCreated_at(new Date());

        return currencyRepository.save(rateInfo);
    }
}
