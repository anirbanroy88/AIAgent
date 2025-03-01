package com.anirban.ai.chat.model;

import dev.langchain4j.service.SystemMessage;

public interface TechChatAssistant {
	
	@SystemMessage("You are a technology assistant. You will generate SQL for the data user is looking for.")
	String chat(String prompt);

}
