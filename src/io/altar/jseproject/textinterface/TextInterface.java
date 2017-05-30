package io.altar.jseproject.textinterface;
	import java.util.Scanner;

import io.altar.jseproject.model.Shelf;
	
public class TextInterface {
	public static void main(String[] args){
		
		System.out.println("Bem Vindo � Productdb\n");
		menuinicial();
	} 

		public static void menuinicial(){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Por favor selecione uma das seguintes opcões:");
			System.out.println("1) Lista produtos");
			System.out.println("2) Lista prateleiras");
			System.out.println("3) Sair");
			
			int menuinp=0;

				boolean valid = false;
				while (!valid){
					while(!scanner.hasNextInt()){
						System.out.println("por favor introduza um caracter numérico");
						scanner.next();
					}
					menuinp	= scanner.nextInt();
					if((menuinp<1 || menuinp>3)){
						System.out.println("Insira um valor entre 1 e 3\n");
					}else{
					valid = true;
					}	
				}

				
			switch(menuinp){
				case 1: 
					prodmenu(scanner);
					break;
				case 2:
					pratmenu(scanner);
					break;
				case 3:
					System.out.println("Thank you for using our aplication.\nGoodbye!!");
					System.exit(0);
					break;
			}
		}
	
		public static void prodmenu(Scanner scanner){	
			System.out.println("Por favor selecione uma das seguintes op��es:");
			System.out.println("1) Criar novo produto");
			System.out.println("2) Editar um produto existente");
			System.out.println("3) Consultar o detalhe de um produto");
			System.out.println("4) Remover um produto");
			System.out.println("5) Voltar ao ecr� anterior");
			
			int prodinp=0;


			boolean valid = false;
			while (!valid){
				while(!scanner.hasNextInt()){
					System.out.println("por favor introduza um caracter numérico");
					scanner.next();
				
				}
					prodinp	= scanner.nextInt();
				if((prodinp<1 || prodinp>5)){
					System.out.println("Insira um valor entre 1 e 5\n");
				
				}else{
				valid = true;
					
				}
				
			}

			System.out.println(prodinp);
			
			switch(prodinp){
				case 1:
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
		
		public static void pratmenu(Scanner scanner){		
			System.out.println("Por favor selecione uma das seguintes op��es:");
			System.out.println("1) Criar nova prateleira");
			System.out.println("2) Editar um produto existente");
			System.out.println("3) Consultar o detalhe de um produto");
			System.out.println("4) Remover um produto");
			System.out.println("5) Voltar ao ecr� anterior");
			
			int pratinp = 0;
			
			boolean valid = false;
			while (!valid){
				while(!scanner.hasNextInt()){
					System.out.println("por favor introduza um caracter numérico");
					scanner.next();
				
				}
					pratinp	= scanner.nextInt();
				if((pratinp<1 || pratinp>5)){
					System.out.println("Insira um valor entre 1 e 5\n");
				
				}else{
				valid = true;
					
				}
				
			}

			System.out.println(pratinp);
//			Object shelf
			Shelf shelfObject = new Shelf(); 
			
			switch(pratinp){
				case 1:
					shelfObject.inpshelf();
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
}
