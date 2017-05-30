package io.altar.jseproject.model;

import java.util.Arrays;
import java.util.Scanner;

public class Shelf {
	private int id;
		private int codigo;
		private int capacidade;
		private int produto;
		private int preco;
	

	public void inpshelf(){
		Scanner dados = new Scanner(System.in);
		
		int shelfarray[]={codigo,capacidade,produto,preco};
		
		id++;
		System.out.println("Insira a localizacão da parteleira: ");
		codigo	= dados.nextInt();
		System.out.println("Insira a capacidade da parteleira: ");
		capacidade = dados.nextInt();
		System.out.println("Insira o ID do produto: ");
		produto = dados.nextInt();
		System.out.println("Insira o precode aluguer diario de localizacão: ");
		preco = dados.nextInt();
		
		System.out.println("ID\tLocalizacão\tCapacidade\tProduto\tCusto(d)");
		System.out.println(id + "\t" + shelfarray[id]);
		
		
	}

}