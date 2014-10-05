package com.arie.objects;

/**
 * Product class which contains the information for a product
 * If no vendor has been assigned to a product it will report 
 * it's vendor as N/A = not available
 * 
 * @author  Arie Radilla Laureano
 */
public class Product {

	private String name  = "";
	private double price = 0;
	private String vendor = "N/A";
	
	public String toString() {
		return this.name + " $" + this.price + " Sold By: " + this.vendor;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getVendor(){
		return this.vendor;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
}
