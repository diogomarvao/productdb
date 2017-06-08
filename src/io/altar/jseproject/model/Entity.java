package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import io.altar.jseproject.Repository.EntityRepository;

public class Entity {
	
	private int id;
	
//get id produtos

	public int getId(){
		return id;
		
	}

//	set id
	
	public void setId(int id){
		this.id=id;
		
	}
	
//inputs de id
	public static int inputId(){
		Scanner getIdInp = new Scanner(System.in);
		
		int id = 0;
		
		boolean valid = false;
		while (!valid){
			while(!getIdInp.hasNextInt()){
				System.out.println("por favor introduza um caracter numerico");
				getIdInp.next();
			}
			id	= getIdInp.nextInt();
		if(id<0 || id>EntityRepository.getEntityList().size()){
				System.out.println("Insira um valor entre " + 1 + " e " + EntityRepository.getEntityList().size() );
			}else{
				valid = true;
			}	
		}
		return id;
	
	}	
	
}

