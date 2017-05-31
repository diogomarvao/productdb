package io.altar.jseproject.textinterface;
	import java.util.Scanner;
	import io.altar.jseproject.model.Product;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
	
	public class TextInterface {

//Menu inicial
		public static void menuinicial(){
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Listar produtos");
			System.out.println("	2) Listar prateleiras");
			System.out.println("	3) Sair");
	
			int menuinp = getMenuInp(1, 3);
				
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
			
			int menuinp = getMenuInp(1, 5);
			
			switch(menuinp){
				case 1:
					newProd();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					menuinicial();
					break;
			}
		}
		
		private static int idProd = 0;
		
//		Criar novo produto
		public static void newProd(){
			Scanner dados = new Scanner(System.in);
			
			
			idProd = idProd + 1;
//			System.out.println("Insira as parteleiras: ");
//			productListadd(prat);
			int prat = 0;
			
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
		
//		Print da tabela
//		public static void printProduct(int id, int prat, double desconto, int iva, double pvp){
//			System.out.println("|\tID\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
//			for(Product p:Product.productList){
//				System.out.println("|\t" + p.id + "\t|\t" + p.desconto + "\t\t|\t" + p.iva + "\t|\t" + p.pvp + "\t|");
//			};
////			
//		}
		
//Menu das prateleiras
		public static void pratmenu(){		
			System.out.println("As prateleiras disponiveis s�o as seguintes:");
			Shelf shelfObject = new Shelf();
			shelfObject.printShelf();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar nova prateleira");
			System.out.println("	2) Editar um produto existente");
			System.out.println("	3) Consultar o detalhe de um produto");
			System.out.println("	4) Remover um produto");
			System.out.println("	5) Voltar ao ecr� anterior");
	
			int menuinp = getMenuInp(1, 5);
				
				switch(menuinp){
					case 1:
						newShelf();
						break;
					case 2:
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
			prodmenu();
			
			}
	
//Input menus com verificacao
		public static int getMenuInp(int min, int max){
			
			Scanner scanner = new Scanner(System.in);	
			int menuinp=0;
			
			boolean valid = false;
			while (!valid){
				while(!scanner.hasNextInt()){
					System.out.println("por favor introduza um caracter numerico");
					scanner.next();
				}
				menuinp	= scanner.nextInt();
				if((menuinp<min || menuinp>max)){
					System.out.println("Insira um valor entre " + min + " e " +max);
				}else{
					valid = true;
				}	
			}
			return menuinp;
		}
}