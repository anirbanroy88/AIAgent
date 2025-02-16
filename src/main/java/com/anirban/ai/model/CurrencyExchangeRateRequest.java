package com.anirban.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Currency exchange rate service API request")
public class CurrencyExchangeRateRequest {

	private String majorCurrency;

	private String minorCurrency;

	public CurrencyExchangeRateRequest(
			@JsonProperty(required = true, value = "majorCurrency") @JsonPropertyDescription("The major currency in the currency pair. The exchange rate will be multiplied to convert from major to minor currency") String majorCurrency,
			@JsonProperty(required = true, value = "minorCurrency") @JsonPropertyDescription("The minor currency in the currency pair. The exchange rate will be multiplied to convert from major to minor currency") String minorCurrency) {
		this.majorCurrency = majorCurrency;
		this.minorCurrency = minorCurrency;
	}

	public String getMajorCurrency() {
		return majorCurrency;
	}

	public void setMajorCurrency(String majorCurrency) {
		this.majorCurrency = majorCurrency;
	}

	public String getMinorCurrency() {
		return minorCurrency;
	}

	public void setMinorCurrency(String minorCurrency) {
		this.minorCurrency = minorCurrency;
	}



}
