package com.anirban.ai.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anirban.ai.service.OpenAILangChainService;

@RestController
@RequestMapping("/anirban/langchain/ai")
public class AILangChainController {

	@Autowired
	private OpenAILangChainService chatService;

	@PostMapping("/chat")
	public ResponseEntity<String> sendChat(@RequestBody List<String> chatMessage) {

		try {
			String response = chatService.sendChat(chatMessage);
			if (response == null || StringUtils.isBlank(response)) {
				return ResponseEntity.internalServerError().body("No response received from CHAT GPT");
			}
			return ResponseEntity.ok().body(response);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("No response from LLM");
		}

	}
	
	@PostMapping("/generateSQL")
	public ResponseEntity<String> getSQL(@RequestBody String context) {

		try {
			String response = chatService.getSQL(context);
			if (response == null || StringUtils.isBlank(response)) {
				return ResponseEntity.internalServerError().body("No response received from CHAT GPT");
			}
			return ResponseEntity.ok().body(response);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("No response from LLM");
		}

	}

}
