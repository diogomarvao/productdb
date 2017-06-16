package io.altar.jseproject.textinterface;
	import java.util.ArrayList;
import java.util.Scanner;

import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.ShelfRepository;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.util.Utils;
	
	public class TextInterface{
		private static ProductRepository productList = ProductRepository.getInstance();
		private static ShelfRepository shelfList = ShelfRepository.getInstance();
		
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
	
// 0 Menu produtos
		public static void prodmenu(){	
			if(productList.isEmpty()){
				System.out.println("A lista de produtos está vazia");
			} else {
				System.out.println("Tem os seguintes produtos em stock:");
				printProduct();
			}
			
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
		
// 1) Criar novo produto
		public static void newProd(){
			Scanner dados = new Scanner(System.in);
			ArrayList<Integer> pratIdLoc= new ArrayList<>();
			int id = productList.getNextId();
			Integer idPrat=0;
			
//		1.1 inserir produtos nas prateleiras	
			
			System.out.println("Deseja inserir o produto criado em alguma prateleira?\n 1-> Sim \n 2-> Nao");
			int menuinp = Utils.getMenuInp(1, 2);
			
			switch(menuinp){
				case 1: 

					if(shelfList == null){
						System.out.println("Nao ha prateleiras criadas, por favor crie uma prateleira");
					}else{	
						System.out.println("Indique a prateleira que pretende inserir o produto: ");
						idPrat=dados.nextInt();
						Product productObject = new Product(pratIdLoc, menuinp, menuinp, menuinp);
						productObject.addToPrat(dados, idPrat, id);

					}
			
				break;
			
				case 2:
					break;
			}

//		1.2 inserir o valor do desconto
			System.out.println("Insira o valor do desconto: ");
			double desconto = Utils.getMenuInp(0, 99999.99);
			
//		1.3 iserir o valor do IVa
			System.out.println("\n | Indique o valor do IVA |");
			System.out.println("	1) 6%");
			System.out.println("	2) 13%");
			System.out.println("	3) 23%");
			
//			Switch Menu
			menuinp = Utils.getMenuInp(1,3);
			int iva=0;
				switch(menuinp){
					case 1:
						iva = 6; 
						break;
					case 2:
						iva = 13;
						break;
					case 3:
						iva = 23;
						break;
				}
				
//		1.4 inserir pvp
			System.out.println("Insira o PVP: ");
			double pvp = dados.nextInt();
			
			Product p = new Product(pratIdLoc, desconto, iva, pvp);
			
		prodmenu();
		
		}
		

// 2) Editar um produto	
		
//	2.1 Introducao do id do prod a alterar	
		public static void prodFind(){
			System.out.println("Insira o ID do produto que pretende editar");
			int id = Product.inputIdProd();
			ProductRepository.getProdElem(id);
		}

//	2.2 introducao dos dados a substituir (valores v�m do ProductRepository.java)
		public static void prodEdit(int idProd, ArrayList<Integer> pratIdLoc, double desconto, int iva, double pvp){
			Scanner dados = new Scanner(System.in);
			
//		2.2.1 Editar prateleiras
			System.out.println("Insira as prateleiras onde o produto est� disposto");
			
			if(ShelfRepository.getInstance() == null){
				System.out.println("Nao ha prateleiras criadas, por favor crie uma prateleira");
				
			}else{	
				Product.editProdPrat(dados, idProd);
				
			}
			
//		2.2.2 Desconto
			System.out.println("Insira o valor do desconto: ");
			System.out.print(desconto + " -> ");
			desconto = Utils.getSkipDouble(dados, desconto);
			
//		2.2.3 IVA
			System.out.println("Insira o valor do IVA: ");
			
			System.out.println("\n | Indique o valor do IVA |");
			System.out.println("| Valor de IVA Actual: " + iva + " |");
			System.out.println("	1) 6%");
			System.out.println("	2) 13%");
			System.out.println("	3) 23%");
			System.out.println("	4) Manter IVA");
			
//			Switch Menu
			int menuinp = Utils.getMenuInp(1,4);
		
				switch(menuinp){
					case 1:
						iva = 6; 
						break;
					case 2:
						iva = 13;
						break;
					case 3:
						iva = 23;
						break;
					case 4:
						break;
				}
		
//		2.2.4 PVP
			System.out.println("Insira o PVP: ");
			System.out.print(pvp  + " -> ");
			pvp = Utils.getSkipDouble(dados, pvp);
			
//		2.2.5 Altera dados
			ProductRepository.alterProdElement(idProd, pratIdLoc, desconto, iva, pvp);
			prodmenu();
		}
		

// 3) Consultar detalhes do produto
		
//		Introducao do id do produto a pesquisar
		public static void prodChars(){
			System.out.println("Introduza o valor do ID do producto que pretende consultar ");
			int id = Product.inputIdProd();
			ProductRepository.getProdDet(id);
		}
		
		
		//print dos detalhes do produto
		public static void printDetails(int id, int prat, double desconto, int iva, double pvp){
			System.out.println("|\tID\t|\tPrateleiras\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t" + id + "\t|\t" + prat + "\t|\t" + desconto + "\t\t|\t" + iva + "\t|\t" + pvp + "\t|");
			System.out.println("-------------------------------------------------------------------------\n");
		}
		
// 4) Eliminar produtos
		
//		Introducao do id do produto a eliminar
		public static void delProd(){
			System.out.println("Insira o Id do produto que pretende eliminar");
			int id = Product.inputIdProd();
			System.out.println("Tem a certeza que prentende eliminar este produto da DB?\n 1 -> Eliminar\n 2 -> Cancelar");
			Product.delElemP(id);
		}		
				
// 0 Menu das prateleiras
		public static void pratmenu(){
			if(shelfList.isEmpty()){
				System.out.println("A lista de prateleiras está vazia");
				
			} else {
				System.out.println("As prateleiras disponiveis s�o as seguintes:");
				printShelf();
				
			}
			
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
						shelfChars();
						break;
					case 4:
						delShelf();
						break;
					case 5:
						menuinicial();
						return;
				}
			}
		
// 1) Criar nova prateleira
		public static void newShelf(){
			Scanner dados = new Scanner(System.in);
			
//		1.1 localizacao
			System.out.println("Insira a localizacao da parteleira: ");
			int codigo = dados.nextInt();
			
//		1.2 Capacidade da prateleira
			System.out.println("Insira a capacidade da parteleira: ");
			int capacidade = dados.nextInt();
			
//		1.3 Inserir produtos na shelf
			System.out.println("Insira o ID do produto: ");
			
//			placeholder
			Integer produto= 0;
//							
		
			
//		1.4 preco de aluguer
			System.out.println("Insira o preco de aluguer diario de localizacao: ");
			double preco = dados.nextInt();
			
//		1.5 Adicionar a shelf
			new Shelf(codigo, capacidade, produto, preco);

			pratmenu();
			
			}

// 2) Editar uma prat	
		
//	2.1 Introducao do id da prat a alterar
		public static void pratFind(){
			System.out.println("Insira o ID da prateleira que pretende editar");
			int id = Shelf.inputIdShelf();
			ShelfRepository.getShelfElem(id);
		}
		
//	2.2 introducao dos dados a substituir
		public static void shelfEdit(int id, int codigo, int capacidade, Integer produto, double preco){
			Scanner dados = new Scanner(System.in);
			
//	  2.2.1 Localizacao das prateleiras
			System.out.println("Insira a localizacao da parteleira: ");
			System.out.print(codigo + " -> ");
			codigo = Utils.getSkipInt(dados, codigo);
			
//	  2.2.2 Capacidade das prateleiras
			System.out.println("Insira a capacidade da parteleira: ");
			System.out.print(capacidade  + " -> ");
			capacidade = Utils.getSkipInt(dados, capacidade);
			
//	  2.2.3 Produtos nas prateleiras
			System.out.println("Insira o ID do produto: ");
			System.out.print(produto  + " -> ");
//			produto = Utils.getSkipDel(dados, produto);
			
//	  2.2.4 Preco diario
			System.out.println("Insira o precode aluguer diario de localizacao: ");
			System.out.print(preco  + " -> ");
			preco = Utils.getSkipDouble(dados, preco);
			
//	  2.2.5 Altera dados
			ShelfRepository.alterShelfElement(id, codigo, capacidade, produto, preco);
			pratmenu();
		}
		
// 3) Consultar detalhes da prateleira
		
//		Introducao do id da prateleira a pesquisar
		public static void shelfChars(){
			System.out.println("Introduza o valor do ID da prateleira que pretende consultar ");
			int id = Shelf.inputIdShelf();
			ShelfRepository.getShelfDet(id);
		}
		
		//print dos detalhes da prateleira
		public static void printShelfDetails(int id, int codigo, int capacidade, Integer produto, double preco){
			System.out.println("|\tID\t|\tLocalizacao\t|\tCapacidade\t|\tProdutos\t|\tAluguer diario\t|");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("|\t" + id + "\t|\t" + codigo + "\t\t|\t" + capacidade + "\t|\t" + produto + "\t|\t" + preco + "\t|");
			System.out.println("---------------------------------------------------------------------------------------\n");
			prodmenu();
		}
		
// 4) Eliminar prateleira
		
//		Introducao do id da prateleira a eliminar
		public static void delShelf(){
			System.out.println("Insira o Id da prateleira que pretende eliminar");
			int id = Shelf.inputIdShelf();
			System.out.println("Tem a certeza que prentende eliminar esta prateleira da DB?/n 1 -> Eliminar/n 2 -> Cancelar");
			Shelf.delElemS(id);
		}		
				

//Imprimir tabelas
		
//		Print da tabela dos produtos
		
	//		Print do cabecalho
			public static void printProduct(){
				System.out.println("|\tID\t|\tPrateleiras\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
				System.out.println("-------------------------------------------------------------------------");
				ProductRepository.valProduct();		
			}
		
//			Print dos valores
			public static void printProductVal(int id, int prat, double desconto, int iva, double pvp){
				System.out.println("|\t" + id + "\t|\t" + prat + "\t|\t" + desconto + "\t\t|\t" + iva + "\t|\t" + pvp + "\t|");
			}
		
			
//		Print da tabela da shelf
			
//			Print do cabecalho
			public static void printShelf(){
				System.out.println("|\tID\t|\tLocalizacao\t|\tCapacidade\t|\tProdutos\t|\tAluguer diario\t|");
				System.out.println("---------------------------------------------------------------------------------------");
				ShelfRepository.valShelf();		
			}
		
//			Print dos valores
			public static void printShelfVal(int id, int codigo, int capacidade, Integer produto, double preco){
				System.out.println("|\t" + id + "\t|\t" + codigo + "\t\t|\t" + capacidade + "\t|\t" + produto + "\t|\t" + preco + "\t|");
			}
		
}		
