package com.ai.storebackend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SearchResponse {
	
	public List<String> list;
	
	public SearchResponse() {
		list = new ArrayList<String>();
	}

	public void add(String skuName)
	{
		list.add(skuName);
	}

	
	
}
