package com.anirban.ai.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAPIRestTemplate {
	
	@Value("${spring.ai.openai.api-key}")
	private String apiKey;
	
	@Bean
	@Qualifier("openApiRestTemplate")
	public RestTemplate getOpenAPIRestTemplate() {
		/*
		 * HttpComponentsClientHttpRequestFactory factory = new
		 * HttpComponentsClientHttpRequestFactory();
		 * factory.setConnectTimeout(Duration.ofMillis(30)); RestTemplate template = new
		 * RestTemplate(factory); template.getInterceptors().add((request, body,
		 * execution) -> { request.getHeaders().add("Authorization", "Bearer " +
		 * apiKey); return execution.execute(request, body); }); return template;
		 */
		return null;
	}

}
