package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class EntityRepository<Product extends Entity> {
	private LinkedHashMap <Integer, Product>productList = new LinkedHashMap<Integer, Product>();
	public static ArrayList<Shelf> shelfList = new ArrayList <Shelf>();
	private int idProd = 0;
		
	
	public int getNextIdProd(){
		
		return ++idProd;
	
	}

//Adicionar produto
	public void addProd(int idProd, int prat, double desconto, int iva, double pvp){
			this.idProd = idProd;
			this.prat = prat;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			productList.put(idProd, this);
		};
	
// delete produto

	public static void delElem(){
		int id = Entity.getId();
		System.out.println("Tem a certeza que prentende eliminar este produto da DB?");
		int input = Utils.getMenuInp(1, 2);
		switch(input){
		case 1:
			productList.remove(id);
			TextInterface.prodmenu();
			break;
		case 2:
			TextInterface.prodmenu();
			break;
		}
		
	}
	
}	


