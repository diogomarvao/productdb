package io.altar.jseproject.model;

import java.util.Arrays;
import java.util.Scanner;

import io.altar.jseproject.textinterface.TextInterface;

public class Shelf {
		private int id;
		private int codigo;
		private int capacidade;
		private int produto;
		private int preco;
	
//criar nova prateleira
	public void newShelf(){
		Scanner dados = new Scanner(System.in);
		
		id += 1;
		
		System.out.println("Insira a localizacão da parteleira: ");
		codigo	= dados.nextInt();
		
		System.out.println("Insira a capacidade da parteleira: ");
		capacidade = dados.nextInt();
		
		System.out.println("Insira o ID do produto: ");
		produto = dados.nextInt();

		System.out.println("Insira o precode aluguer diario de localizacao: ");
		preco = dados.nextInt();

		TextInterface textinterfaceObject = new TextInterface();
		textinterfaceObject. pratmenu();
	}

//print da tabela
	public static void printShelf(){
		System.out.println("|\tID\t|\tLocalizacão\t|\tCapacidade\t| Produto\t|\tCusto(d)\t|");
	}
//		for(int counter=0; counter<=idArray.length; counter++ ){
//			System.out.println(id + "\t" + locArray[id] + "\t" + capArray[id] + "\t" + proArray[id] + "\t" + preArray[id]);
//	}
//
	}