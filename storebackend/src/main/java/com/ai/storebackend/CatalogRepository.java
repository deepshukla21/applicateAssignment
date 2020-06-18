package com.ai.storebackend;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, String>{

	@Query(value = "SELECT sku_name FROM catalog WHERE catalog.sku_code LIKE %:searchTerm% OR catalog.sku_name LIKE %:searchTerm% OR catalog.sku_desc LIKE %:searchTerm% OR catalog.brand_name LIKE %:searchTerm% AND catalog.supplier_id=:supplierId", nativeQuery=true)
	List<String> findAllByTerm(String searchTerm, Integer supplierId);
	
	
}
