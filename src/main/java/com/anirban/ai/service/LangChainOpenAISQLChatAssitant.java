package com.anirban.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anirban.ai.chat.model.TechChatAssistant;
import com.anirban.ai.configuration.OpenAIConfiguration;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.model.openai.OpenAiTokenizer;
import dev.langchain4j.service.AiServices;

@Component
public class LangChainOpenAISQLChatAssitant {
	
	
	private TechChatAssistant assistant;
	
	
	public LangChainOpenAISQLChatAssitant(@Autowired OpenAIConfiguration config) {
		ChatLanguageModel model = OpenAiChatModel.builder().apiKey(config.getOpenAIApiKey())
				.modelName(OpenAiChatModelName.GPT_4_O_MINI).build();
		ChatMemory chatMemory = TokenWindowChatMemory.withMaxTokens(10000000, new OpenAiTokenizer(OpenAiChatModelName.GPT_4_O_MINI));
		assistant = AiServices.builder(TechChatAssistant.class).chatLanguageModel(model)
				.chatMemory(chatMemory)
				.build();	
	}
	
	public String generateSQL(String context) {
		Object response = assistant.chat(context);
		return response.toString();
	}

}
