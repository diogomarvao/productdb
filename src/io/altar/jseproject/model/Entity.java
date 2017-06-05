package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Entity {

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

}

