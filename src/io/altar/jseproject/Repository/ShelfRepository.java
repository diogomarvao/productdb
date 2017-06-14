package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class ShelfRepository extends EntityRepository <Shelf>{

	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	private ShelfRepository(){}
	
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}

	
//Indentificar elementos da shelf a alterar (metodo chamado na TextInterface.java)

		public static void getShelfElem(int id){
			int codigo = ((Shelf)ShelfRepository.getInstance().get(id)).getCod();
			int capacidade = ((Shelf)ShelfRepository.getInstance().get(id)).getCap();
			Integer produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
			double preco = ((Shelf)ShelfRepository.getInstance().get(id)).getPreco();
			TextInterface.shelfEdit(id, codigo, capacidade, produto, preco);
			};	
		
//Indentificar elementos da shelf para ver detalhes (ver shelf.java para vars, metodo chamado na textInterface.java)

		public static void getShelfDet(int id){
			int codigo = ((Shelf)ShelfRepository.getInstance().get(id)).getCod();
			int capacidade = ((Shelf)ShelfRepository.getInstance().get(id)).getCap();
			Integer produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
			double preco = ((Shelf)ShelfRepository.getInstance().get(id)).getPreco();
			TextInterface.printShelfDetails(id, codigo, capacidade, produto, preco);
			};	
		
			
//substituir ou adicionar as caraterisiticas no Linked hash map (chamado na TextInterface.java)	
		
		public static void alterShelfElement(int id,int codigo, int capacidade, Integer produto, double preco) {
			((Shelf)ShelfRepository.getInstance().get(id)).setCod(codigo);
			((Shelf)ShelfRepository.getInstance().get(id)).setCap(capacidade);
			((Shelf)ShelfRepository.getInstance().get(id)).setProd(produto);
			((Shelf)ShelfRepository.getInstance().get(id)).setPreco(preco);
		}

		
//Print valores da tabela da shelf (chamdo na TextInterface.java)
		public static void valShelf(){
//													keySet() -> ver EntityRepository
			for (Integer id : getInstance().keySet()) {
//			 retirar osa valores das variaveis por cada id
				int codigo = ((Shelf)ShelfRepository.getInstance().get(id)).getCod();
				int capacidade = ((Shelf)ShelfRepository.getInstance().get(id)).getCap();
				Integer produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
//				int produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
				double preco = ((Shelf)ShelfRepository.getInstance().get(id)).getPreco();
//																						Envia os valores para a TextInterface serem inpressos 
				TextInterface.printShelfVal(id, codigo, capacidade, produto, preco);
				 
			}

		}	
		
}
		

		

