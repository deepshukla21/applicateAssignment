package com.ai.storebackend;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class SearchRequest {
	@JsonProperty("supplierId")
	public Integer supplierId;
	@JsonProperty("searchTerm")
	public String  searchTerm;
	
    public SearchRequest() {
		
	}
	
	public SearchRequest(Integer supplierId, String searchTerm) {
		
		this.supplierId = supplierId;
		this.searchTerm = searchTerm;
	}

	
	
	
	
}
