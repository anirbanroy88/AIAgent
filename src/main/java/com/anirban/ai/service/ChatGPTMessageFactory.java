package com.anirban.ai.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;

import com.anirban.ai.model.OpenAIMessageType;

public class ChatGPTMessageFactory {

	private static final String DEFAULT_SYSTEM_MESSAGE = "You are a helpful assistant";
	private static final String DEFAULT_USER_MESSAGE = "How is the weather in Bangalore today?";

	public static Message getMessageofType(OpenAIMessageType type, String messageText) {

		if (StringUtils.isBlank(messageText)) {
			switch (type) {
			case SYSTEM: {
				messageText = DEFAULT_SYSTEM_MESSAGE;
				break;
			}
			case USER:
				messageText = DEFAULT_USER_MESSAGE;
				break;
			default:
				break;
			}
		}
		switch (type) {
		case SYSTEM:
			return new SystemMessage(messageText);
		case ASSISTANT:
			return new AssistantMessage(messageText);
		case USER:
			return new UserMessage(messageText);
		default:
			return new UserMessage(messageText);
		}

	}
}
