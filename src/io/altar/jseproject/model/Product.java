package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class Product extends Entity {
		private int idProd;
		private List<Integer> prat = new ArrayList<Integer>();
		private double desconto;
		private int iva;
		private double pvp;		

//setters das variaveis
		
		public void setPrat(List<Integer> prat){
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

		public static List<Integer> getPrat(){
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
		
		
//adicionar a parteleira criada ao repositorio shelfRepository
		
		public Product(List<Integer> prat, double desconto, int iva, double pvp) {
			this.prat = prat;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			ProductRepository.getInstance().addToList(this);
		}

//	Adicionar produtos nas prateleiras
		
		public static void addProd(){
			System.out.println("Insira o ID da prateleira que pretende inserir o produto:");
			getPrat().add(idProd);
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
		