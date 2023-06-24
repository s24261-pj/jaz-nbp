package com.example.jaz.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CurrencyTable {

    @Size(min = 1, max = 255)
    @Schema(description = "Currency table")
    public String table;

    @Size(min = 1, max = 255)
    @Schema(description = "Currency name")
    public String currency;

    @Size(min = 1, max = 255)
    @Schema(description = "Currency code")
    public String code;

    @Size(min = 1, max = 255)
    @Schema(description = "Currency rates list")
    public List<Rate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
