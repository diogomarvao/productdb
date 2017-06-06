package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.textinterface.TextInterface;

public class Product extends Entity {
		private int idProd;
		private int prat;
		private double desconto;
		private int iva;
		private double pvp;		

//setters das variaveis
		
		public void setPrat(int prat){
			this.prat=prat;
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

		public int getPrat(){
			return this.prat;
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
				
//adicionar ao repositorio variaveis
		public Product(int prat, double desconto, int iva, double pvp) {
			this.prat = prat;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			ProductRepository.getInstance().addToList(this);
		}
		
		
//Print valores da tabela do prod
		
	public static void valProduct(){
		for(Interger i : entityList.keySet()){
			
		}
				
//				int i = 1; i<entityList.size(); i++ ){
//			int id = i;
//			int prat = ((Product)ProductRepository.getInstance().get(id)).getPrat();
//			double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
//			int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
//			double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
//			TextInterface.printProductVal (id, prat, desconto, iva, pvp);
//		}	
	}
		
}
		