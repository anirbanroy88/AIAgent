package com.anirban.ai.functions;

import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.context.annotation.Configuration;

import com.anirban.ai.model.ClientPositionRequest;
import com.anirban.ai.service.ClientPositionService;

@Configuration
public class OpenAIStockFunctionCallback {

	public FunctionCallback clientPosition() {
		return FunctionCallback.builder().function("ClientPosition", new ClientPositionService()) // (1) function name
																									// and instance
				.description("Get client position by type") // (2) function description
				.inputType(ClientPositionRequest.class) // (3) function input type
				.build();
	}

}
