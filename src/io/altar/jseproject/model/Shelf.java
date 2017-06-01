package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import io.altar.jseproject.textinterface.TextInterface;

public class Shelf {
		private int idShelf;
		private int codigo;
		private int capacidade;
		private int produto;
		private double preco;
	
		public static ArrayList<Shelf> shelfList = new ArrayList <Shelf>();
		
		public void Shelf(int idShelf, int codigo, int capacidade, int produto, double preco) {
			this.idShelf = idShelf;
			this.codigo = codigo;
			this.capacidade = capacidade;
			this.produto = produto;
			this.preco = preco;
			shelfList.add(this);
		}
		
		public static void shelfEleFind(int idEditS){
			
			int id=idEditS;
			int codigo=shelfList.get(idEditS-1).codigo;
			int capacidade=shelfList.get(idEditS-1).capacidade;
			int produto=shelfList.get(idEditS-1).produto;
			double preco=shelfList.get(idEditS-1).preco;
			TextInterface.shelfEdit(id, codigo, capacidade, produto, preco);
			
		};	
	
	
		public static void sEdit(int id, int codigo, int capacidade, int produto, double preco){
			
			shelfList.get(id-1).codigo = codigo;
			shelfList.get(id-1).capacidade = capacidade;
			shelfList.get(id-1).produto = produto;
			shelfList.get(id-1).preco = preco;
			TextInterface.pratmenu();
			
		}
		
		public static void printShelf(){
			System.out.println("|\tID\t|\tCodigo\t|\tCapacidade\t|\tProduto\t|\tPre�o\t|");
			System.out.println("-----------------------------------------------------------------------------------------");
			for(Shelf s:Shelf.shelfList){
				System.out.println("|\t" + s.idShelf + "\t|\t" + s.codigo + "\t\t|\t" + s.capacidade + "\t|\t" + s.produto + "\t|\t" + s.preco + "\t|");
			};
//			
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
