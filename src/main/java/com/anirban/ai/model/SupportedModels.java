package com.anirban.ai.model;

public enum SupportedModels {
	
	GPT_4o_MINI("OPENAI","gpt-4o-mini");
	
	private String modelOrganization;
	
	private String modelName;

	private SupportedModels(String modelOrganization, String modelName) {
		this.modelOrganization = modelOrganization;
		this.modelName = modelName;
	}

	public String getModelOrganization() {
		return modelOrganization;
	}


	public String getModelName() {
		return modelName;
	}


}
