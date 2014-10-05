package com.arie.objects;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterable object which holds a group of products.
 * At the moment it implements the Iterable Interface as for the moment
 * the only required functionality is to loop thorugh the objects.
 * 
 * In the future as this WebCrawler is extended it would be good to consider if 
 * it could become a Collection
 * @author  Arie Radilla Laureano
 */
public class Catalog implements Iterable<Product>{
	private ArrayList<Product> products = new ArrayList<Product>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator iterator() {
		 Iterator<Product> iprof = products.iterator();
		 return iprof; 
	}

	/**
     * Add a new object to the catalog
     * 
     * @param product The product to be added to the catalog
     */	
	public void addProduct(Product product){
		products.add(product);
	}
	
	/**
     * Retrieve a specific object in the catalog
     * 
     * @param index The position in which the catalog is located at
     * @return product the product stored in the collection
     */
	public Product getProduct(int index){
		return products.get(index);
	}

	/**
     * Obtain the size of the catalog
     * 
     * @return size the size of the catalog
     */
	public int size() {
		return products.size();
	}
	
}
