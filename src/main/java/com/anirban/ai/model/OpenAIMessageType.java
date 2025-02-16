package com.anirban.ai.model;

public enum OpenAIMessageType {
	
	USER("user"),SYSTEM("system"),ASSISTANT("assistant");
	
	private String type;
	
	private OpenAIMessageType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	

}
