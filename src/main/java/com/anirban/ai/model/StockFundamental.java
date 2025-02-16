package com.anirban.ai.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class StockFundamental {
	
	@JsonPropertyDescription("The last traded market price in USD")
	private double currentPrice;
	
	private String currency;
	
	private double peRatio;
	
	private double fiftyTwoWeekhigh;
	
	private double fiftyTwoWeekLow;
	
	private double earningPerShare;
	
	private double marketCapitalization;
	
	private double fiftyDayMovingAverage;
	
	private double twoHundredDayMovingAverage;
	
	private Double rsiIndex;

	public double getEarningPerShare() {
		return earningPerShare;
	}

	public void setEarningPerShare(double earningPerShare) {
		this.earningPerShare = earningPerShare;
	}

	public double getFiftyDayMovingAverage() {
		return fiftyDayMovingAverage;
	}

	public void setFiftyDayMovingAverage(double fiftyDayMovingAverage) {
		this.fiftyDayMovingAverage = fiftyDayMovingAverage;
	}

	public double getTwoHundredDayMovingAverage() {
		return twoHundredDayMovingAverage;
	}

	public void setTwoHundredDayMovingAverage(double twoHundredDayMovingAverage) {
		this.twoHundredDayMovingAverage = twoHundredDayMovingAverage;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(double peRatio) {
		this.peRatio = peRatio;
	}

	public double getFiftyTwoWeekhigh() {
		return fiftyTwoWeekhigh;
	}

	public void setFiftyTwoWeekhigh(double fiftyTwoWeekhigh) {
		this.fiftyTwoWeekhigh = fiftyTwoWeekhigh;
	}

	public double getFiftyTwoWeekLow() {
		return fiftyTwoWeekLow;
	}

	public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
		this.fiftyTwoWeekLow = fiftyTwoWeekLow;
	}

	public double getMarketCapitalization() {
		return marketCapitalization;
	}

	public void setMarketCapitalization(double marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getRsiIndex() {
		return rsiIndex;
	}

	public void setRsiIndex(Double rsiIndex) {
		this.rsiIndex = rsiIndex;
	}
	
	

}
