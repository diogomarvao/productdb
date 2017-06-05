package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class ProductRepository extends EntityRepository<Product>{

	private static final ProductRepository INSTANCE = new ProductRepository();
	private ProductRepository(){
		
		int prat = getPrat();
		double desconto = getDesconto();
		int iva = getIva();
		double pvp = getPvp();
		
	}
	
	public static ProductRepository getInstance(long id){
		return INSTANCE;
	}
	
}
