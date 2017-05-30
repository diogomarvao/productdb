package io.altar.jseproject.model;

import java.util.Scanner;

import io.altar.jseproject.textinterface.TextInterface;

public class Product {
	private int id;
	private int prod;
	private int desconto;
	private int iva;
	private int pvp;

	public void  newProd(){
		Scanner dados = new Scanner(System.in);
		
		id += 1;
		
		System.out.println("Insira as parteleiras: ");
		prod	= dados.nextInt();
		
		System.out.println("Insira o valor do desconto: ");
		desconto = dados.nextInt();
		
		System.out.println("Insira o valor do IVA: ");
		iva = dados.nextInt();

		System.out.println("Insira o PVP: ");
		pvp = dados.nextInt();
		
		TextInterface textinterfaceObject = new TextInterface();
		textinterfaceObject. prodmenu();
	}
	
	
	public static void printproduct(){
	System.out.println("|\tID\t|\tPrateleiras\t|\tDesconto\t|\tIVA\t|\tPVP\t|");
	
	}
}