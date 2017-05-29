package io.altar.jseproject.textinterface;

	import java.util.Scanner;

public class TextInterface {
	
	public static void main(String[] args){
		
		System.out.println("Por favor selecione uma das seguintes opcões:");
		System.out.println("1) Lista produtos");
		System.out.println("2) Lista prateleiras");
		System.out.println("3) Sair");
	} 
	
	public static void proddisp(String [] args){
		
		System.out.println("Por favor selecione uma das seguintes opcões:");
		System.out.println("1) Criar novo produto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecrã anterior");
		
	}
	
public static void pratdisp(String [] args){
		
		System.out.println("Por favor selecione uma das seguintes opcões:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecrã anterior");
		
	}

}
