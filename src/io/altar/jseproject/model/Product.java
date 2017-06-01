package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Scanner;

import io.altar.jseproject.textinterface.TextInterface;

public class Product {
		private int idProd;
		private int prat;
		private double desconto;
		private int iva;
		private double pvp;
	
		public static ArrayList<Product> productList = new ArrayList <Product>();
		
		public void Product(int idProd, int prat, double desconto, int iva, double pvp) {
			this.idProd = idProd;
			this.prat = prat;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			productList.add(this);
		}
		
		public static void prodEleFind(int idEditP){
			
				int id=idEditP;
				double desconto=productList.get(idEditP-1).desconto;
				int iva=productList.get(idEditP-1).iva;
				 double pvp=productList.get(idEditP-1).pvp;
				TextInterface.prodEdit(id, desconto, iva, pvp);
				
			};	
		
		
		public static void pEdit(int id, double desconto, int iva, double pvp){
			
			productList.get(id-1).desconto = desconto;
			productList.get(id-1).iva = iva;
			productList.get(id-1).pvp = pvp;
			TextInterface.prodmenu();
			
		}
		
		public static void printProduct(){
			System.out.println("|\tID\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
			System.out.println("-------------------------------------------------------------------------");
			for(Product p:Product.productList){
				System.out.println("|\t" + p.idProd + "\t|\t" + p.desconto + "\t\t|\t" + p.iva + "\t|\t" + p.pvp + "\t|");
			};
	//		
		}
}