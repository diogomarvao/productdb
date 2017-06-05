package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class EntityRepository<E extends Entity> {
	private Integer id = 0;
//	private LinkedHashMap<Integer ,Entity> entityList = new LinkedHashMap<>();
	private LinkedHashMap <Integer, Product>productList = new LinkedHashMap<Integer, Product>();
	public static ArrayList<Shelf> shelfList = new ArrayList <Shelf>();
	
	public Integer getNextId() {
		return ++id;
	}
	
	public void addElement(Product product){
		product.setId(getNextId());
		
	}
	
	public void addProd(Product product) {
		product.setId(getNextId());
		productList.put(product.getId(),product);
		
	}
	
	public static void delProd(int id){
		productList.remove(id);
	}
	
	
	
	
	public Product findById(long id){
		return productList.get(id);
		
	}
		
}	

