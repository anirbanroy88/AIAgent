package com.anirban.ai.functions;

import java.util.List;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.anirban.ai.data.Position;
import com.anirban.ai.model.ClientPositionRequest;
import com.anirban.ai.service.ClientPositionService;

@Configuration
public class OpenAIStockFunctions {
	
	@Bean
	@Description("Get client position of type")
	public Function<ClientPositionRequest, List<Position>> clientPosition(){
		return new ClientPositionService();
	}

}
