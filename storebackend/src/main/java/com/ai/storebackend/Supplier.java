package com.ai.storebackend;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private Integer supplierId;
	@Column(nullable = false)
	private String supplierName;
	@OneToMany(mappedBy = "supplier")
	private List<Catalog> catlog = new ArrayList<>();
	
	// Getter and Setter for all fields
	
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public List<Catalog> getCatlog() {
		return catlog;
	}
	public void setCatlog(List<Catalog> catlog) {
		this.catlog = catlog;
	}
	
	
	
}
