package com.ai.storebackend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StoreController {
	
	@Autowired
	private SupplierRepository supplierRepo;
	
	@Autowired
	private CatalogRepository catalogRepo;
	

	
	@PostMapping("/saveSupplier")
	public Supplier saveSupplier(@RequestBody Supplier newSupplier)
	{
		supplierRepo.save(newSupplier);
		return newSupplier;		
	}
	
	@PostMapping("/saveCatalog")
	public String saveCatalog(@RequestBody NewCatalogItem catalogItem)
	{
		// While saving mapping the received parameter to catalog object
		Supplier supplier = supplierRepo.findById(catalogItem.sid).get();
		Catalog catalog = new Catalog();
		catalog.setSkuCode(catalogItem.skuCode);
		catalog.setSkuName(catalogItem.skuName);
		catalog.setSkuDesc(catalogItem.skuDesc);
		catalog.setBrandDesc(catalogItem.brandDesc);
		catalog.setBrandName(catalogItem.brandName);

		catalog.setSupplier(supplier);
		catalogRepo.save(catalog);
		return catalog.getSkuCode();
		
	}
	
	@PostMapping("/search")
	public SearchResponse  getSku(@RequestBody SearchRequest searchParams)
	{
		
		Integer supplierId = searchParams.supplierId;
		String  searchTerm = searchParams.searchTerm;
		List<String> matchingCatItems;
		SearchResponse skuNames = new SearchResponse();
		
		matchingCatItems = catalogRepo.findAllByTerm(searchTerm, supplierId);

		for(String c1 : matchingCatItems)
		{
			skuNames.add(c1);
		}
		
		return skuNames;
	}
	
	
}
