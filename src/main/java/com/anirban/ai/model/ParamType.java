package com.anirban.ai.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public enum ParamType {
	
	@JsonPropertyDescription("Fetch long or short position")LONG_SHORT,
	@JsonPropertyDescription("Fetch trade date or settlement date position") TD_SD,
	@JsonPropertyDescription("The currency for which position is to be fetched") CURRENCY,
	@JsonPropertyDescription("Fetch all positions") ALL

}
