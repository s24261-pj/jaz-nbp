package com.example.jaz.currency.repository;

import com.example.jaz.currency.model.RateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<RateInfo, Long> {
    RateInfo save(RateInfo rateInfo);
}
