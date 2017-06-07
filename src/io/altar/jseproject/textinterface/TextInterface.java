package io.altar.jseproject.textinterface;
	import java.util.Scanner;

import io.altar.jseproject.util.Utils;
import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.ShelfRepository;
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
	
// 0 Menu produtos
		public static void prodmenu(){	
			System.out.println("Tem os seguintes produtos em stock:");
			printProduct();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar novo produto");
			System.out.println("	2) Editar um produto existente");
			System.out.println("	3) Consultar o detalhe de um produto");
			System.out.println("	4) Remover um produto");
			System.out.println("	5) Voltar ao ecrï¿½ anterior");
			
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
						
			System.out.println("Insira as parteleiras: ");
			int prat [] = pratExp();
			System.out.println("Insira o valor do desconto: ");
			double desconto = dados.nextInt();
			System.out.println("Insira o valor do IVA: ");
			int iva = dados.nextInt();
			System.out.println("Insira o PVP: ");
			double pvp = dados.nextInt();
			
			Product p = new Product(prat, desconto, iva, pvp);
			
		prodmenu();
		
		}

// 2) Editar um produto	
		
//		Introducao do id do prod a alterar	
		public static void prodFind(){
			System.out.println("Insira o ID do produto que pretende editar");
			int id = Entity.inputId();
			ProductRepository.getProdElem(id);
		}

//		introducao dos dados a substituir (valores vêm do ProductRepository.java)
		public static void prodEdit(int idProd, int prat, double desconto, int iva, double pvp){
			Scanner dados = new Scanner(System.in);
			System.out.println("Insira as prateleiras onde o produto estï¿½ disposto");
			System.out.print(prat + " -> ");
			prat=Utils.getSkipDel(dados, prat);
			System.out.println("Insira o valor do desconto: ");
			System.out.print(desconto + " -> ");
			desconto = Utils.getSkipDouble(dados, desconto);
			System.out.println("Insira o valor do IVA: ");
			System.out.print(iva  + " -> ");
			iva = Utils.getSkipInt(dados, iva);
			System.out.println("Insira o PVP: ");
			System.out.print(pvp  + " -> ");
			pvp = Utils.getSkipDouble(dados, pvp);
			ProductRepository.alterProdElement(idProd, prat, desconto, iva, pvp);
			prodmenu();
		}
		

// 3) Consultar detalhes do produto
		
//		Introducao do id do produto a pesquisar
		public static void prodChars(){
			System.out.println("Introduza o valor do ID do producto que pretende consultar ");
			int id = Entity.inputId();
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
			int id = Entity.inputId();
			System.out.println("Tem a certeza que prentende eliminar este produto da DB?/n 1 -> Eliminar/n 2 -> Cancelar");
			Product.delElemP(id);
		}		
				
// 0 Menu das prateleiras
		public static void pratmenu(){		
			System.out.println("As prateleiras disponiveis sï¿½o as seguintes:");
			printShelf();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar nova prateleira");
			System.out.println("	2) Editar um prateleira existente");
			System.out.println("	3) Consultar os detalhes de uma prateleira");
			System.out.println("	4) Remover prateleira");
			System.out.println("	5) Voltar ao ecrï¿½ anterior");
	
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
			
			System.out.println("Insira a localizacao da parteleira: ");
			int codigo = dados.nextInt();
			System.out.println("Insira a capacidade da parteleira: ");
			int capacidade = dados.nextInt();
			System.out.println("Insira o ID do produto: ");
			int produto = dados.nextInt();
			System.out.println("Insira o precode aluguer diario de localizacao: ");
			double preco = dados.nextInt();
			
			Shelf s = new Shelf(codigo, capacidade, produto, preco);

			pratmenu();
			
			}

// 2) Editar uma prat	
		
//		Introducao do id da prat a alterar
		public static void pratFind(){
			System.out.println("Insira o ID da prateleira que pretende editar");
			int id = Entity.inputId();
			ShelfRepository.getShelfElem(id);
		}
		
//		introducao dos dados a substituir
		public static void shelfEdit(int id, int codigo, int capacidade, int produto, double preco){
			Scanner dados = new Scanner(System.in);
			System.out.println("Insira a localizacao da parteleira: ");
			System.out.print(codigo + " -> ");
			codigo = Utils.getSkipInt(dados, codigo);
			System.out.println("Insira a capacidade da parteleira: ");
			System.out.print(capacidade  + " -> ");
			capacidade = Utils.getSkipInt(dados, capacidade);
			System.out.println("Insira o ID do produto: ");
			System.out.print(produto  + " -> ");
			produto = Utils.getSkipDel(dados, produto);
			System.out.println("Insira o precode aluguer diario de localizacao: ");
			System.out.print(preco  + " -> ");
			preco = Utils.getSkipDouble(dados, preco);
			ShelfRepository.alterShelfElement(id, codigo, capacidade, produto, preco);
			prodmenu();
		}
		
// 3) Consultar detalhes da prateleira
		
//		Introducao do id da prateleira a pesquisar
		public static void shelfChars(){
			System.out.println("Introduza o valor do ID da prateleira que pretende consultar ");
			int id = Entity.inputId();
			ShelfRepository.getShelfDet(id);
		}
		
		//print dos detalhes da prateleira
		public static void printShelfDetails(int id, int codigo, int capacidade, int produto, double preco){
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
			int id = Entity.inputId();
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
			public static void printShelfVal(int id, int codigo, int capacidade, int produto, double preco){
				System.out.println("|\t" + id + "\t|\t" + codigo + "\t\t|\t" + capacidade + "\t|\t" + produto + "\t|\t" + preco + "\t|");
			}
		
}		
