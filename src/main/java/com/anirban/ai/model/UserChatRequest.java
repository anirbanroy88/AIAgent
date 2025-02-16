package com.anirban.ai.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class UserChatRequest {
	
	private String model;
	
	private List<Message> messages;
	
	private int maxCompletionTokens;
	
	private double topP;
	
	private double temperatue;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public double getTemperatue() {
		return temperatue;
	}

	public void setTemperatue(double temperatue) {
		this.temperatue = temperatue;
	}

	public int getMaxCompletionTokens() {
		return maxCompletionTokens;
	}

	public void setMaxCompletionTokens(int maxCompletionTokens) {
		this.maxCompletionTokens = maxCompletionTokens;
	}

	public double getTopP() {
		return topP;
	}

	public void setTopP(double topP) {
		this.topP = topP;
	}
	
	public boolean isProperMessage() {
		if(this.messages == null || this.messages.size() == 0) {
			return false;
		}
		return messages.stream().anyMatch(m -> !StringUtils.isEmpty(m.getContent()));
	}

	
}
