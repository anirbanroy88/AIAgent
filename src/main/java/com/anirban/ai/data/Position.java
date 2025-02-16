package com.anirban.ai.data;


public class Position {
	
	private Type type;
	
	private EffectiveAsOf effective;
	
	private String stockName;
	
	private double quantity;
	
	private String currency;
	
	public Position(Type type, EffectiveAsOf effective, String stockName, double quantity, String currency) {
		this.type = type;
		this.effective = effective;
		this.stockName = stockName;
		this.quantity = quantity;
		this.currency = currency;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public EffectiveAsOf getEffective() {
		return effective;
	}

	public void setEffective(EffectiveAsOf effective) {
		this.effective = effective;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}
