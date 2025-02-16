package com.anirban.ai.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.OpenAiChatOptions.Builder;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.ai.openai.api.ResponseFormat.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import com.anirban.ai.model.ClientPositionRequest;
import com.anirban.ai.model.CurrencyExchangeRateRequest;
import com.anirban.ai.model.OpenAIMessageType;
import com.anirban.ai.model.PositionStatistics;
import com.anirban.ai.model.StockFundamental;
import com.anirban.ai.model.UserChatRequest;

@Service
public class OpenAISpringChatService {

	@Autowired
	private OpenAiApi api;

	public String sendChat(String modelName, UserChatRequest chatMessage) throws Exception {

		OpenAiChatModel chatModel = constructOpenAIChatModel();
		List<Message> messages = chatMessage.getMessages().stream().map(
				m -> ChatGPTMessageFactory.getMessageofType(OpenAIMessageType.valueOf(m.getRole()), m.getContent()))
				.toList();
		Builder chatOptionsBuilder = OpenAiChatOptions.builder().model(modelName);
		if (chatMessage.getTemperatue() > 0) {
			chatOptionsBuilder.temperature(chatMessage.getTemperatue());
		}
		if (chatMessage.getMaxCompletionTokens() > 0) {
			chatOptionsBuilder.maxCompletionTokens(chatMessage.getMaxCompletionTokens());
		}
		if (chatMessage.getTopP() > 0) {
			chatOptionsBuilder.topP(chatMessage.getTopP());
		}
		BeanOutputConverter<StockFundamental> beanoutputConverter = new BeanOutputConverter<StockFundamental>(
				StockFundamental.class);
		System.out.println(beanoutputConverter.getJsonSchema());
		Prompt prompt = new Prompt(messages, chatOptionsBuilder.build());

		ChatResponse response = chatModel.call(prompt);
		List<Generation> generations = response.getResults();
		String textResponse = generations.stream().map(g -> g.getOutput().getText()).collect(Collectors.joining("\n"));
		return textResponse;
	}

	public StockFundamental getStockDetails(String stockName) throws Exception {

		OpenAiChatModel chatModel = constructOpenAIChatModel();
		Builder chatOptionsBuilder = OpenAiChatOptions.builder().model("gpt-4o-mini");
		chatOptionsBuilder.temperature(0.5);
		BeanOutputConverter<StockFundamental> beanoutputConverter = new BeanOutputConverter<StockFundamental>(
				StockFundamental.class);
		System.out.println(beanoutputConverter.getJsonSchema());
		StockFundamental fundamentals = ChatClient.create(chatModel).prompt()
				.user(u -> u.text("Provide details about {stockName} stock").param("stockName", stockName)).call()
				.entity(StockFundamental.class);
		return fundamentals;
	}

	public PositionStatistics getPositionStatistics(String query) throws Exception {

		UserMessage userMessage = new UserMessage(query);
		SystemMessage systemMessage = new SystemMessage("Get prices of stocks");
		OpenAiChatModel chatModel = constructOpenAIChatModel();
		Builder chatOptionsBuilder = OpenAiChatOptions.builder().model("gpt-4o-mini");
		chatOptionsBuilder.temperature(0.5);
		BeanOutputConverter<PositionStatistics> beanOutputConverter = new BeanOutputConverter<PositionStatistics>(PositionStatistics.class);
		chatOptionsBuilder.functionCallbacks(List.of(
				FunctionCallback.builder().function("clientPosition", new ClientPositionService())
						.description("Get client position by type").inputType(ClientPositionRequest.class).build(),
				FunctionCallback.builder().function("currencyExchangeRate", new CurrencyExchangeRateService())
						.description("Get exchange rate between major and minor currency")
						.inputType(CurrencyExchangeRateRequest.class).build()));
		//chatOptionsBuilder.responseFormat(ResponseFormat.builder().jsonSchema(beanOutputConverter.getJsonSchema()).type(Type.JSON_SCHEMA).build());
		ChatResponse response = chatModel.call(new Prompt(List.of(systemMessage,userMessage), chatOptionsBuilder.build()));
		Generation generation = response.getResult();
		System.out.println(beanOutputConverter.getJsonSchema());
		PositionStatistics statistics = beanOutputConverter
				.convert(generation.getOutput().getContent());
		return statistics;
	}

	public String getChatResponse(String modelName, String textMessage, OpenAIMessageType messageType)
			throws Exception {

		OpenAiChatModel chatModel = constructOpenAIChatModel();
		Message message = ChatGPTMessageFactory.getMessageofType(messageType, textMessage);
		Prompt prompt = new Prompt(message);
		ChatResponse response = chatModel.call(prompt);
		List<Generation> generations = response.getResults();
		String textResponse = generations.stream().map(g -> g.getOutput().getText()).collect(Collectors.joining("\n"));
		return textResponse;

	}

	public String getChatResponse(String modelName, String message, String context) {
		return message;

	}

	private OpenAiChatModel constructOpenAIChatModel() {
		OpenAiChatModel model = new OpenAiChatModel(api);
		return model;
	}

}
