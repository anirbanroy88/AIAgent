package com.anirban.ai.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anirban.ai.model.StockFundamental;
import com.anirban.ai.model.SupportedModels;
import com.anirban.ai.model.UserChatRequest;
import com.anirban.ai.service.OpenAISpringChatService;

@RestController
@RequestMapping("/anirban/spring/ai")
public class AISpringChatController {

	@Autowired
	private OpenAISpringChatService chatService;

	@PostMapping("/chat")
	public ResponseEntity<String> sendChat(@RequestBody UserChatRequest chatMessage) {
		if (chatMessage != null && chatMessage.isProperMessage()) {

			try {
				SupportedModels aiModel = SupportedModels.valueOf(chatMessage.getModel());
				String response = chatService.sendChat(aiModel.getModelName(), chatMessage);
				if (response == null || StringUtils.isBlank(response)) {
					return ResponseEntity.internalServerError().body("No response received from CHAT GPT");
				}
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				return ResponseEntity.badRequest().body("Model " + chatMessage.getModel() + " is not supported");
			}
		}
		return ResponseEntity.badRequest().body("There is no message to send to the model");
	}
	
	@GetMapping("/getStockDetails/{stockName}")
	public ResponseEntity<StockFundamental> getStockDetails(@PathVariable(required = true,name = "stockName") String stockName) {
		try {
			StockFundamental response = chatService.getStockDetails(stockName);
			if(response == null) {
				return ResponseEntity.noContent().build();
			}	
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PostMapping("/getPositionStats")
	public ResponseEntity<String> getPositionStatistics(@RequestBody String queryString) {
		try {
			chatService.getPositionStatistics(queryString);
			return ResponseEntity.ok("Completed");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}


}
