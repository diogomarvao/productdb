package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class Shelf extends Entity {
		private int codigo;
		private int capacidade;
		private Integer produto;
		private double preco;
	
//setters das variaveis	
		
		public void setCod(int codigo){
			this.codigo=codigo;
		}
		
		public void setCap(int capacidade){
			this.capacidade=capacidade;
		}
		
		public void setProd(Integer produto){
			this.produto=produto;
		}
		
		public void setPreco(double preco){
			this.preco=preco;
		}
	
//getters das variaveis

		public int getCod(){
			return this.codigo;
		}
		
		public int getCap(){
			return this.capacidade;
		}
		
		public Integer getProd(){
			return this.produto;
		}
		
		public double getPreco(){
			return this.preco;
		}
		
		
//adicionar a parteleira criada ao repositorio shelfRepository

		public Shelf(int codigo, int capacidade, Integer produto, double preco) {
			this.codigo = codigo;
			this.capacidade = capacidade;
			this.produto = produto;
			this.preco = preco;
			ShelfRepository.getInstance().addToList(this);
		}

		
///		/Eliminar Shelfs (chamado na TextInterface.java)
		
		public static void delElemS(int id){
			int input = Utils.getMenuInp(1, 2);
			switch(input){
			case 1:
//				O produto � morto na EntityRepository.java
				ShelfRepository.getInstance().removElem(id);
				TextInterface.pratmenu();
				break;
			case 2:
				TextInterface.pratmenu();
				break;
			}
		}
			
//inputs de id
		public static int inputIdShelf(){
			Scanner getIdInp = new Scanner(System.in);
			
			int id = 0;
			
			boolean valid = false;
			while (!valid){
				while(!getIdInp.hasNextInt()){
					System.out.println("por favor introduza um caracter numerico");
					getIdInp.next();
				}
				id	= getIdInp.nextInt();
			if(id<0 || id>ShelfRepository.getInstance().getEntityList().size()){
					System.out.println("Insira um valor entre " + 1 + " e " + ShelfRepository.getInstance().getEntityList().size() );
				}else{
					valid = true;
				}	
			}
			return id;
		
		}
}
		
