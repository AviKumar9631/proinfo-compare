package com.lumen.productinfo.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Features {
	
	public String featureName;
	public String featureIndicator;
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getFeatureIndicator() {
		return featureIndicator;
	}
	public void setFeatureIndicator(String featureIndicator) {
		this.featureIndicator = featureIndicator;
	}
	

}
