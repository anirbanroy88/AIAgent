package com.anirban.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication ( scanBasePackages = {"com.anirban.ai.*","com.anirban.data.*"})
public class AIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AIApplication.class);
    }
}
