package com.cbfacademy.apiassessment.model;

import java.time.LocalDateTime;

public record CustomerInfo(
    Long id,
    String firstName,
    String lastName,
    String email,
   // InvestmentPreferences investmentPreferences,
    Goal goal,
    RiskLevel riskLevel,
    Duration duration,
    StockSymbol stockSymbol,
    LocalDateTime createdDate,
    LocalDateTime updatedDate,
    String url
) {
    
}
