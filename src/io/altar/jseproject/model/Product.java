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
	
		
//		Indentificar elementos do produto
		
		public static void prodEleFind(int idEditP){		
				ProductRepository.getProdElem(idEditP);
			};	
		
		
//		substituir as caraterisiticas no Linked hash map	
		
		public static void pEdit(int id, int prat, double desconto, int iva, double pvp){
		ProductRepository.alterElement(id, prat, desconto, iva, pvp);
		}
		
		
		
//Print da tabela do prod
		
		public static void printProduct(){
			System.out.println("|\tID\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
			System.out.println("-------------------------------------------------------------------------");
			
			for(int eq = 1; eq<productList.size(); eq++ ){
				int id = eq;
				int prat = productList.get(eq).prat;
				double desconto = productList.get(eq).desconto;
				int iva = productList.get(eq).iva;
				double pvp = productList.get(eq).pvp;	
				System.out.println("|\t" + id + "\t|\t" + desconto + "\t\t|\t" + iva + "\t|\t" + pvp + "\t|");
			}	
		}
		
//print das caracteristicas do produto
		public static void printChars(){
			int id = getId();
			int prat = productList.get(id).prat;
			double desconto = productList.get(id).desconto;
			int iva = productList.get(id).iva;	
			double pvp = productList.get(id).pvp;

			System.out.println("|\tID\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t" + id + "\t|\t" + desconto + "\t\t|\t" + iva + "\t|\t" + pvp + "\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			
		}
		
	
//getters das variaveis
//		public int getIdProd(){
//			return idProd;
//		}
//		
//		public int getPrat(){
//			return prat;
//		}
//		
//		public double getDesconto(){
//			return desconto;
//		}
//		
//		public int getIva(){
//			return iva;
//		}
//		
//		public double getPvp(){
//			return pvp;
//		}
			
}
		