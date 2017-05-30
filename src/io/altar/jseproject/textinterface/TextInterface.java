package io.altar.jseproject.textinterface;
	import java.util.Scanner;

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
			Product productObject = new Product();
			productObject.printproduct();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar novo produto");
			System.out.println("	2) Editar um produto existente");
			System.out.println("	3) Consultar o detalhe de um produto");
			System.out.println("	4) Remover um produto");
			System.out.println("	5) Voltar ao ecrï¿½ anterior");
			
			int menuinp = getMenuInp(1, 5);
			
			switch(menuinp){
				case 1:
					productObject.newProd();
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
		
		//Menu das prateleiras
		public static void pratmenu(){		
			System.out.println("As prateleiras disponiveis são as seguintes:");
			Shelf shelfObject = new Shelf();
			shelfObject.printShelf();
			
			System.out.println("\n | Por favor selecione uma das seguintes opcoes: |");
			System.out.println("	1) Criar nova prateleira");
			System.out.println("	2) Editar um produto existente");
			System.out.println("	3) Consultar o detalhe de um produto");
			System.out.println("	4) Remover um produto");
			System.out.println("	5) Voltar ao ecrï¿½ anterior");
	
			int menuinp = getMenuInp(1, 5);
				
				switch(menuinp){
					case 1:
						shelfObject.newShelf();
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
	
		//Input menus com verificação
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