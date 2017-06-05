package io.altar.jseproject.textinterface;
	import java.util.Scanner;

import io.altar.jseproject.util.Utils;
import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
	
	public class TextInterface{

//Menu inicial
		public static void menuinicial(){
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Listar produtos");
			System.out.println("	2) Listar prateleiras");
			System.out.println("	3) Sair");
	
			int menuinp = Utils.getMenuInp(1, 3);
				
			switch(menuinp){
				case 1: 
					prodmenu();
					break;
				case 2:
					pratmenu();
					break;
				case 3:
					System.out.println(" Obrigado por ter usado o programa.\nAdeus!! ");
					System.exit(0);
					break;
			}
		}
	
//Menu produtos
		public static void prodmenu(){	
			System.out.println("Tem os seguintes produtos em stock:");
			Product.printProduct();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar novo produto");
			System.out.println("	2) Editar um produto existente");
			System.out.println("	3) Consultar o detalhe de um produto");
			System.out.println("	4) Remover um produto");
			System.out.println("	5) Voltar ao ecr� anterior");
			
			int menuinp = Utils.getMenuInp(1, 5);
			
			switch(menuinp){
				case 1:
					newProd();
					break;
				case 2:
					prodFind();
					break;
				case 3:
					prodChars();
					break;
				case 4:
					delProd();
					break;
				case 5:
					menuinicial();
					break;
			}
		}
		
//		Criar novo produto
		public static void newProd(){
			Scanner dados = new Scanner(System.in);
						
			int idProd = EntityRepository.getNextIdProd();
			System.out.println("Insira as parteleiras: ");
//			productListadd(prat);
			int prat = dados.nextInt();
			
			System.out.println("Insira o valor do desconto: ");
			double desconto = dados.nextInt();
			
			System.out.println("Insira o valor do IVA: ");
			int iva = dados.nextInt();
			
			System.out.println("Insira o PVP: ");
			double pvp = dados.nextInt();
			
			Product current = new Product();
			
		current.Product(idProd, prat, desconto, iva, pvp);	
		prodmenu();
		
		}

//Editar um produto		
		public static void prodFind(){
			Scanner dados = new Scanner(System.in);
			System.out.println("Insira o ID doproduto que pretende editar");
			int idEditP = dados.nextInt();
			Product.prodEleFind(idEditP);
		}
		
		public static void prodEdit(int idProd, int prat, double desconto, int iva, double pvp){
			Scanner dados = new Scanner(System.in);
			System.out.println("Insira as prateleiras onde o produto est� disposto");
			System.out.print(prat + " -> ");
			prat=Utils.getSkipDel(prat);
			System.out.println("Insira o valor do desconto: ");
			System.out.print(desconto + " -> ");
			desconto = dados.nextInt();
			System.out.println("Insira o valor do IVA: ");
			System.out.print(iva  + " -> ");
			iva = Utils.getSkipInt(iva);
			iva = dados.nextInt();
			System.out.println("Insira o PVP: ");
			System.out.print(pvp  + " -> ");
			pvp = dados.nextInt();
			Product.pEdit(idProd, prat, desconto, iva, pvp);
		}
		
//Consultar detalhes do produto
		public static void prodChars(){
			System.out.println("Introduza o valor do ID do producto que pretende consultar ");
			Product.printChars();
			prodmenu();
		}
		
//Eliminar produto
		public static void delProd(){
			System.out.println("Insira o Id do produto que pretende eliminar");
			EntityRepository.delElem();
		}		
				
//Menu das prateleiras
		public static void pratmenu(){		
			System.out.println("As prateleiras disponiveis s�o as seguintes:");
			Shelf.printShelf();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar nova prateleira");
			System.out.println("	2) Editar um prateleira existente");
			System.out.println("	3) Consultar os detalhes de uma prateleira");
			System.out.println("	4) Remover prateleira");
			System.out.println("	5) Voltar ao ecr� anterior");
	
			int menuinp = Utils.getMenuInp(1, 5);
				
				switch(menuinp){
					case 1:
						newShelf();
						break;
					case 2:
						pratFind();
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						menuinicial();
						return;
				}
			}
		
		private static int idShelf = 0;
		
////		Criar nova prateleira
		public static void newShelf(){
			Scanner dados = new Scanner(System.in);
			
			idShelf = idShelf + 1;
			System.out.println("Insira a localizacao da parteleira: ");
			int codigo = dados.nextInt();
			
			System.out.println("Insira a capacidade da parteleira: ");
			int capacidade = dados.nextInt();
			
			System.out.println("Insira o ID do produto: ");
			int produto = dados.nextInt();
			
			System.out.println("Insira o precode aluguer diario de localizacao: ");
			double preco = dados.nextInt();
			
			Shelf current = new Shelf();
			
			current.Shelf(idShelf,codigo, capacidade, produto, preco);	
			pratmenu();
			
			}

//			Editar uma prat		
		public static void pratFind(){
			Scanner dados = new Scanner(System.in);
			System.out.println("Insira o ID da prateleira que pretende editar");
			int idEditS = dados.nextInt();
			Shelf.shelfEleFind(idEditS);
		}
		
		public static void shelfEdit(int idShelf, int codigo, int capacidade, int produto, double preco){
			Scanner dados = new Scanner(System.in);
			System.out.println("Insira a localizacao da parteleira: ");
			System.out.print(codigo + " -> ");
			codigo = Utils.getSkipInt(codigo);
			System.out.println("Insira a capacidade da parteleira: ");
			System.out.print(capacidade  + " -> ");
			capacidade = Utils.getSkipInt(capacidade);
			System.out.println("Insira o ID do produto: ");
			System.out.print(produto  + " -> ");
			produto = Utils.getSkipDel(produto);
			System.out.println("Insira o precode aluguer diario de localizacao: ");
			System.out.print(preco  + " -> ");
			preco = dados.nextInt();
			Shelf.sEdit(idShelf, codigo, capacidade, produto, preco);
		}
				
}