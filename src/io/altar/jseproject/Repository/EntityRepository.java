package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public abstract class EntityRepository <Product extends Entity> {
	private Map <Long, Product>productList = new LinkedHashMap<Long, Product>();
	public static ArrayList<Shelf> shelfList = new ArrayList <Shelf>();
	
	private long index = 0;
	
	protected Long getNextId() {
		return ++index;
	}
	
	public Product findById(long id){
		return productList.get(id);
	}
		
	
//getters das variaveis
	public Product getCollection(long id){
		Collection<Product> values = productList.values();
		return values;
	}
	
	public Product getPrat(long id){
		return findById(id).prat;
	}
	
	public Product getDesconto(long id){
		return findById(id).desconto;
	}
	
	public Product getIva(long id){
		return findById(id).iva;
	}
	
	public Product getPvp(long id){
		return findById(id).pvp;
	}
			
}	

