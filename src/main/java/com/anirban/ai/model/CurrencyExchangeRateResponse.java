package com.anirban.ai.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class CurrencyExchangeRateResponse {
	
	@JsonPropertyDescription("Exchange rate to be applied to convert from major currency to minor currency")
	private Double exchangeRate;
	
	@JsonPropertyDescription("The mathematical operation to be done to convert from major currency to minor currency")
	private String operation;

	public CurrencyExchangeRateResponse(Double exchangeRate, String operation) {
		this.exchangeRate = exchangeRate;
		this.operation = operation;
	}
	
	public CurrencyExchangeRateResponse(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
		this.operation = "Multiply";
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
