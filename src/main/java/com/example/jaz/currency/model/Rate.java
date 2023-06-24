package com.example.jaz.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

public class Rate {

    @Size(min = 1, max = 255)
    @Schema(description = "Currency no")
    public String no;

    @Size(min = 1, max = 255)
    @Schema(description = "Currency effective date")
    public String effectiveDate;

    @Schema(description = "Currency mid")
    public float mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public float getMid() {
        return mid;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setMid(float mid) {
        this.mid = mid;
    }
}
