package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Scanner;

import io.altar.jseproject.textinterface.TextInterface;

public class Product {
	private int id;
	private int prat[][];
	private int desconto;
	private int iva;
	private int pvp;


	public Product(int id, int[][] prat, int desconto, int iva, int pvp) {
		this.id = id;
		this.prat = prat;
		this.desconto = desconto;
		this.iva = iva;
		this.pvp = pvp;
	}

	public static ArrayList<Product> productList = new ArrayList <Product>();
	
}