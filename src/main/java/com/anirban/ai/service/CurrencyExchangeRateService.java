package com.anirban.ai.service;

import java.util.function.Function;
import org.springframework.stereotype.Service;
import com.anirban.ai.data.CurrencyExchangeRateData;
import com.anirban.ai.data.CurrencyPair;
import com.anirban.ai.model.CurrencyExchangeRateRequest;
import com.anirban.ai.model.CurrencyExchangeRateResponse;

@Service
public class CurrencyExchangeRateService implements Function<CurrencyExchangeRateRequest, CurrencyExchangeRateResponse>{

	private CurrencyExchangeRateData exchangeRate = CurrencyExchangeRateData.getInstance();
	
	@Override
	public CurrencyExchangeRateResponse apply(CurrencyExchangeRateRequest t) {
		if(exchangeRate.getAllExchangeRates().containsKey(new CurrencyPair(t.getMajorCurrency(), t.getMinorCurrency()))) {
			Double rate = exchangeRate.getAllExchangeRates().get(new CurrencyPair(t.getMajorCurrency(), t.getMinorCurrency()));
			return new CurrencyExchangeRateResponse(rate);
		}else if (exchangeRate.getAllExchangeRates().containsKey(new CurrencyPair(t.getMinorCurrency(), t.getMajorCurrency()))) {
			Double rate = exchangeRate.getAllExchangeRates().get(new CurrencyPair(t.getMinorCurrency(), t.getMajorCurrency()));
			return new CurrencyExchangeRateResponse(rate,"divide");
		}else {
			return new CurrencyExchangeRateResponse(1.0);
		}
	}

}
