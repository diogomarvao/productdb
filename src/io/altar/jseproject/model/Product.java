package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class Product extends Entity {
		private static ProductRepository productList = ProductRepository.getInstance();
		private static ShelfRepository shelfList = ShelfRepository.getInstance();
	
		private static Integer [] pratIdLoc;
		private double desconto;
		private int iva;
		private double pvp;		

//setters das variaveis
		
		public void setPrat(Integer [] pratIdLoc){
			this.pratIdLoc=pratIdLoc;
		}
		
		public void setDesconto(double desconto){
			this.desconto=desconto;
		}
		
		public void setIva(int iva){
			this.iva=iva;
		}
		
		public void setPvp(double pvp){
			this.pvp=pvp;
		}
		
//getters das variaveis
		
		public static Integer [] getPratIdLoc(){
			return pratIdLoc;
		}

		public Integer[] getPrat(){
			return this.pratIdLoc;
		}

		public double getDesconto(){
			return this.desconto;
		}
		
		public int getIva(){
			return this.iva;
		}
		
		public double getPvp(){
			return this.pvp;
		}
		

//	Adicionar produtos nas prateleiras
		
		public static Integer[] addToPrat(Scanner dados, int id){
			int i=0;
//			pedir opiniao
			while(pratIdLoc[i] == id){
				
				for(i=0; i<pratIdLoc.length; i++){
					if(pratIdLoc[i] == id){
						System.out.println("Indique outra prateleira");
						id = dados.nextInt();
					}		
				}
				
			}
				pratIdLoc[pratIdLoc.length+1] = id; 
				produto[produto.length+1] = getId();
				return pratIdLoc;
			
		}
		
//	Editar o produto na prateleira	
		public static int editProdPrat(Scanner dados, int id){
			int i=0;
//			pedir opiniao
			while(pratIdLoc[i] != id){
				
				for(i=0; i<pratIdLoc.length; i++){
					if(pratIdLoc[i] == id){
						id = Utils.getSkipDel(dados, id);
						break;
					}		
				}
				
			}
			int idProd = id;
			return idProd;
			
		}


//adicionar a parteleira criada ao repositorio shelfRepository

		public Product(Integer [] pratIdLoc, double desconto, int iva, double pvp) {
			this.pratIdLoc = pratIdLoc;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			ProductRepository.getInstance().addToList(this);
		}

		
//		Eliminar produtos (chamado na TextInterface.java)
		
		public static void delElemP(int id){
			int input = Utils.getMenuInp(1, 2);
			switch(input){
			case 1:
//				O produto � morto na EntityRepository.java
				EntityRepository.removElem(id);
				TextInterface.prodmenu();
				break;
			case 2:
				TextInterface.prodmenu();
				break;
			}
		}
		
}
		