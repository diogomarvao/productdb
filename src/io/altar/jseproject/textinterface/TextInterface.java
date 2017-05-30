package io.altar.jseproject.textinterface;

	import java.util.Scanner;

public class TextInterface {
	
	public static void main(String[] args){
		
		System.out.println("Bem Vindo à Productdb\n");
		
		TextInterface textInterfaceObject = new TextInterface();
		textInterfaceObject.menuinicial();
		
	} 

		public void menuinicial(){
			
			System.out.println("Por favor selecione uma das seguintes opcÃµes:");
			System.out.println("1) Lista produtos");
			System.out.println("2) Lista prateleiras");
			System.out.println("3) Sair");
			
			int menuinp;
			
			Scanner input = new Scanner(System.in);
			menuinp	= input.nextInt();

			while (menuinp<1 | menuinp>3){
					
					System.out.println("Insira um valor entre 1 e 3\n");
					menuinp	= input.nextInt();
				}
				
			switch(menuinp){
				case 1: 
					TextInterface textInterfaceObject1 = new TextInterface();
					textInterfaceObject1.prodmenu();
					break;
				case 2:
					TextInterface textInterfaceObject2 = new TextInterface();
					textInterfaceObject2.pratmenu();
					break;
				case 3:
					System.out.println("Thank you for using our aplication.\nGoodbye!!");
					System.exit(0);
					break;
			}
		}
	
		public void prodmenu(){	
			System.out.println("Por favor selecione uma das seguintes opções:");
			System.out.println("1) Criar novo produto");
			System.out.println("2) Editar um produto existente");
			System.out.println("3) Consultar o detalhe de um produto");
			System.out.println("4) Remover um produto");
			System.out.println("5) Voltar ao ecrã anterior");
			
			int prodinp;
			Scanner input = new Scanner(System.in);
			prodinp	= input.nextInt();
			
			while (prodinp<1 | prodinp>5){
					
					System.out.println("Insira um valor entre 1 e 5\n");
					prodinp	= input.nextInt();
				}
			
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
				TextInterface textInterfaceObject = new TextInterface();
				textInterfaceObject.menuinicial();
				break;
			}
		}
		
		public void pratmenu(){		
			System.out.println("Por favor selecione uma das seguintes opções:");
			System.out.println("1) Criar nova prateleira");
			System.out.println("2) Editar um produto existente");
			System.out.println("3) Consultar o detalhe de um produto");
			System.out.println("4) Remover um produto");
			System.out.println("5) Voltar ao ecrã anterior");
			
			int pratinp;
			Scanner input = new Scanner(System.in);
			pratinp	= input.nextInt();
			
			while (pratinp<1 | pratinp>5){
				
				System.out.println("Insira um valor entre 1 e 5\n");
				pratinp	= input.nextInt();
			}
			
			switch(pratinp){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				TextInterface textInterfaceObject = new TextInterface();
				textInterfaceObject.menuinicial();
				return;
			}
		}
}
