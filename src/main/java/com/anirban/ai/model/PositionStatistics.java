package com.anirban.ai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionStatistics {
	
	public PositionStatistics() {
		this.positionByCurrency = new HashMap<String, List<UnderlyingStocks>>();
	}

	@JsonPropertyDescription("The total USD market value of the filtered client positions")
	@JsonProperty(required = true)
	private Double totalMarketValueInUSD;

	@JsonPropertyDescription("The total USD market value by currency.The key is currency and the value is the list of positions for the currency")
	private Map<String, List<UnderlyingStocks>> positionByCurrency;

	public Double getTotalMarketValueInUSD() {
		return totalMarketValueInUSD;
	}

	public void setTotalMarketValueInUSD(Double totalMarketValueInUSD) {
		this.totalMarketValueInUSD = totalMarketValueInUSD;
	}

	public Map<String, List<UnderlyingStocks>> getPositionByCurrency() {
		return positionByCurrency;
	}

	public void setPositionByCurrency(Map<String, List<UnderlyingStocks>> positionByCurrency) {
		this.positionByCurrency = positionByCurrency;
	}

	public class UnderlyingStocks {

		@JsonPropertyDescription("The name of the stock in the position")
		@JsonProperty(required = true)
		private String stockName;

		@JsonPropertyDescription("The total number of shares")
		private Double quantity;

		@JsonPropertyDescription("Market value of the stock in local currency")
		private Double totalMarketValueInLocalCurrency;

		@JsonPropertyDescription("Market value of the stock in USD")
		private Double marketValueInUSD;
		
		public UnderlyingStocks() {
			
		}

		public String getStockName() {
			return stockName;
		}

		public void setStockName(String stockName) {
			this.stockName = stockName;
		}


		public Double getQuantity() {
			return quantity;
		}

		public void setQuantity(Double quantity) {
			this.quantity = quantity;
		}

		public Double getTotalMarketValueInLocalCurrency() {
			return totalMarketValueInLocalCurrency;
		}

		public void setTotalMarketValueInLocalCurrency(Double totalMarketValueInLocalCurrency) {
			this.totalMarketValueInLocalCurrency = totalMarketValueInLocalCurrency;
		}

		public Double getMarketValueInUSD() {
			return marketValueInUSD;
		}

		public void setMarketValueInUSD(Double marketValueInUSD) {
			this.marketValueInUSD = marketValueInUSD;
		}

	

	}

}
