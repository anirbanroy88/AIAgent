package com.anirban.ai.data;

import java.util.Objects;

public class CurrencyPair {
	
	private String majorCurrency;
	
	private String minorCurrency;

	public CurrencyPair(String majorCurrency, String minorCurrency) {
		this.majorCurrency = majorCurrency;
		this.minorCurrency = minorCurrency;
	}

	public String getMajorCurrency() {
		return majorCurrency;
	}

	public String getMinorCurrency() {
		return minorCurrency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(majorCurrency, minorCurrency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyPair other = (CurrencyPair) obj;
		return Objects.equals(majorCurrency, other.majorCurrency) && Objects.equals(minorCurrency, other.minorCurrency);
	}
	
	

}
