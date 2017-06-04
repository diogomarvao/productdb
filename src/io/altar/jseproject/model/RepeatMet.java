package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RepeatMet {

	public static LinkedHashMap <Integer, Product>productList = new LinkedHashMap<Integer, Product>();
	public static ArrayList<Shelf> shelfList = new ArrayList <Shelf>();
	
	
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

		
//get id produtos	

		public static int getId(){
			Scanner getIdInp = new Scanner(System.in);
			
			int id = 0;
			
			boolean valid = false;
			while (!valid){
				while(!getIdInp.hasNextInt()){
					System.out.println("por favor introduza um caracter numerico");
					getIdInp.next();
				}
				id	= getIdInp.nextInt();
				if(id<0 || id>productList.size()){
					System.out.println("Insira um valor entre " + 1 + " e " + productList.size() );
				}else{
					valid = true;
				}	
			}
			return id;
			
		}
		
//Skip com enter int	
		public static int getSkipInt(int y){
			Scanner dados = new Scanner(System.in);
			String x = dados.nextLine();
			
			if(dados.equals("") || dados.equals(" ")){
				y = y;
			} else if (x.matches("\\d+")){
				y = Integer.parseInt(x);
			}
				return y;
			};
			
//Skip com enter double
//			public static int getSkipDouble(double y){
//				Scanner dados = new Scanner(System.in);
//				String x = dados.nextLine();
//				
//				if(dados.equals("") || dados.equals(" ")){
//					y = y;
//				} else if (x.matches("-?\\d+(\\.\\d+)?")){
//					y = Double.parseDouble(x);
//				}
//
//				};

//Skip com enter para delete (lista de produtos e prateleiras)	
			public static int getSkipDel(int y){
				Scanner dados = new Scanner(System.in);
				String x = dados.nextLine();
				
				if(dados.equals("") || dados.equals(" ")){
					y = 1;
				} else if (x.matches("\\d+")){
					y = Integer.parseInt(x);
				}
					return y;
				};
				
}

