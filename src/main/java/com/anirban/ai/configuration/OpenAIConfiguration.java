package com.anirban.ai.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfiguration {
	
	@Value("${spring.ai.openai.api-key}")
	private String openAIApiKey;
	
	@Value("{openapi.base.url}")
	private String openAIchatCompletionUrl;
	
	@Value("{openapi.max.tokens}")
	private String maxTokens;
	
	@Value("{openapi.temperature}")
	private String temperature;
	
	

	@Bean
	@Qualifier("api")
	public OpenAiApi getOpenAIAPI() {
		OpenAiApi api = new OpenAiApi(openAIApiKey);
		return api;
	}



	public int getMaxTokens() {
		if(StringUtils.isNumeric(maxTokens)) {
			return Integer.valueOf(maxTokens);
		}else {
			return 10000;
		}
	}



	public Double getTemperature() {
		if(StringUtils.isNumeric(temperature)) {
			return Double.valueOf(temperature);
		}else {
			return 1.0;
		}
	}



	public String getOpenAIApiKey() {
		return openAIApiKey;
	}

	
	
}
