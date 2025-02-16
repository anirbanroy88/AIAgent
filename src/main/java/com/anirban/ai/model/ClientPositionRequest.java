package com.anirban.ai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Client position service API request")
public class ClientPositionRequest {
	
	private List<ClientPositionRequestQueryParam> queryParams;

	public List<ClientPositionRequestQueryParam> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(@JsonProperty(required = true,value="queryParam") @JsonPropertyDescription("The query parameters based on which client position is to be fetched")List<ClientPositionRequestQueryParam> queryParams) {
		this.queryParams = queryParams;
	} 

}
