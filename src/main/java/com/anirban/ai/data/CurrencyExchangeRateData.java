package com.anirban.ai.data;

import java.util.HashMap;
import java.util.Map;
import jakarta.annotation.PostConstruct;

public class CurrencyExchangeRateData {
	
	private Map<CurrencyPair, Double> exchangeRate;
	private static CurrencyExchangeRateData SINGLE_INSTANCE;
	
	private CurrencyExchangeRateData() {
		this.exchangeRate = new HashMap<CurrencyPair, Double>();
		init();
	}
	
	@PostConstruct
	private void init() {
		exchangeRate.put(new CurrencyPair("USD", "INR"), 87.593);
		exchangeRate.put(new CurrencyPair("USD", "EUR"), 0.968);
		exchangeRate.put(new CurrencyPair("USD", "AUD"), 1.594);
		exchangeRate.put(new CurrencyPair("EUR", "AUD"), 1.646);
		exchangeRate.put(new CurrencyPair("EUR", "INR"), 90.491);
		exchangeRate.put(new CurrencyPair("INR", "CAD"), 0.016);
		exchangeRate.put(new CurrencyPair("CAD", "USD"), 0.7);
	}
	
	public Map<CurrencyPair, Double> getAllExchangeRates(){
		return this.exchangeRate;
	}

	public static CurrencyExchangeRateData getInstance() {
		if(SINGLE_INSTANCE == null) {
			SINGLE_INSTANCE = new CurrencyExchangeRateData();
		}
		return SINGLE_INSTANCE;
	}
}
