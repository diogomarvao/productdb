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
	
//	Indentificar elementos do produto (ver produtos.java)
	
	public static void getProdElem(int id){
			int prat = productList.get(id).prat;
			double desconto = productList.get(id).desconto;
			int iva = productList.get(id).iva;
			double pvp = productList.get(id).pvp;
			
			TextInterface.prodEdit(id, prat, desconto, iva, pvp);
		};	
	
//		inserir produto no Array
		
	public void Product(int idProd, int prat, double desconto, int iva, double pvp) {
		addProd(idProd, prat, desconto, iva, pvp);
//		this.idProd = idProd;
//		this.prat = prat;
//		this.desconto = desconto;
//		this.iva = iva;
//		this.pvp = pvp;
//		productList.put(idProd, this);
	}
			
//	substituir as caraterisiticas no Linked hash map (veio da Product.java)	
	
	public static void alterElement(int id, int prat, double desconto, int iva, double pvp){
		
		productList.get(id).desconto = desconto;
		productList.get(id).iva = iva;
		productList.get(id).pvp = pvp;
		TextInterface.prodmenu();
	}
	
}
