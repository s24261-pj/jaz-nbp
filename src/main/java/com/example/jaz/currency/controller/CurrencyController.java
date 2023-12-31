package com.example.jaz.currency.controller;

import com.example.jaz.currency.model.CurrencyTable;
import com.example.jaz.currency.model.RateInfo;
import com.example.jaz.currency.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{currency}")
    @Operation(summary = "Get currency rate between two dates")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get the currency rate",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyTable.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "502",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "504",
                    description = "Gateway timeout",
                    content = @Content
            )
    })
    public ResponseEntity<RateInfo> getRateInfo(
            @PathVariable(value="currency") String currency,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        return ResponseEntity.ok(currencyService.getRateInfo(currency, startDate, endDate));
    }
}
