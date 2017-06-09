package io.altar.jseproject.util;

import java.util.Scanner;

public class Utils {
	
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
	
			
				
	//Skip com enter int	
			public static int getSkipInt(Scanner dados, int y){
				String x = dados.nextLine();
				
				if(dados.equals("") || dados.equals(" ")){
					y = y;
				} else if (x.matches("\\d+")){
					y = Integer.parseInt(x);
				}
					return y;
				};
				
				
//	Skip com enter double
				public static double getSkipDouble(Scanner dados, double y){
					String x = dados.nextLine();
					
					if(dados.equals("") || dados.equals(" ")){
						y = y;
					} else if (x.matches("-?\\d+(\\.\\d+)?")){
						y = Double.parseDouble(x);
					}
						return y;
					};

	//Skip com enter para delete (lista de produtos e prateleiras)	
				public static int getSkipDel(Scanner dados, int y){
					String x = dados.nextLine();
					
					if(dados.equals("") || dados.equals(" ")){
						y = 0;
					} else if (x.matches("\\d+")){
						y = Integer.parseInt(x);
					}
						return y;
					};
					
}
