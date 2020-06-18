package com.ai.storebackend;

import org.springframework.stereotype.Component;


// Interface to map request parameter to catalog object
@Component
public class NewCatalogItem {
	
	public Integer sid;    
    public String skuCode;
    public String skuName;
    public String skuDesc;
    public String brandName;
    public String brandDesc;
    
    public NewCatalogItem() {
    }

	public NewCatalogItem(Integer sid, String skuCode, String skuName, String skuDesc, String brandName,
			String brandDesc) {
		this.sid = sid;
		this.skuCode = skuCode;
		this.skuName = skuName;
		this.skuDesc = skuDesc;
		this.brandName = brandName;
		this.brandDesc = brandDesc;
	}

	


	
}
