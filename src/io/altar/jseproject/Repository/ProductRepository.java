package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class ProductRepository extends EntityRepository<Product>{

	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository(){}
	
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	
//	substituir as caraterisiticas no Linked hash map (veio da Product.java)	
	
	public static void alterElement(int id, int prat, double desconto, int iva, double pvp){
		
		productList.get(id).desconto = desconto;
		productList.get(id).iva = iva;
		productList.get(id).pvp = pvp;
		TextInterface.prodmenu();
	}
	
}
