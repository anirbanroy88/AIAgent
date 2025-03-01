package com.anirban.ai.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anirban.ai.configuration.OpenAIConfiguration;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.Content;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel.OpenAiChatModelBuilder;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.model.output.Response;

@Service
public class OpenAILangChainService {

	@Autowired
	private OpenAIConfiguration config;
	
	@Autowired
	LangChainOpenAISQLChatAssitant sqlAssistantService;

	public String sendChat(List<String> messages) {
		OpenAiChatModelBuilder chatModelBuilder = new OpenAiChatModelBuilder();
		chatModelBuilder.apiKey(config.getOpenAIApiKey());
		chatModelBuilder.modelName(OpenAiChatModelName.GPT_4_O_MINI);
		OpenAiChatModel chatModel = chatModelBuilder.build();
		List<Content> contents = messages.stream().map(m -> new TextContent(m)).collect(Collectors.toList());
		ChatMessage chatMessage = UserMessage.from(contents);
		Response<AiMessage> response = chatModel.generate(List.of(chatMessage));
		String textResponse = response.content().text();
		return textResponse;
	}

	public String getSQL(String context) {
		return sqlAssistantService.generateSQL(context);
	}

}
