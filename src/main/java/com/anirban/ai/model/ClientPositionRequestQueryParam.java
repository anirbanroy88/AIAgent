package com.anirban.ai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientPositionRequestQueryParam {
	
	private ParamType paramType;
	
	private String value;
	
	public ClientPositionRequestQueryParam()
	{
		this.paramType = ParamType.ALL;
	}
	
	public ClientPositionRequestQueryParam(@JsonProperty(value = "queryParameter") ParamType paramType, @JsonProperty(value = "queryValue") String value) {
		this.paramType = paramType;
		this.value = value;
	}

	public ParamType getParamType() {
		return paramType;
	}

	public void setParam(ParamType paramType) {
		this.paramType = paramType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
