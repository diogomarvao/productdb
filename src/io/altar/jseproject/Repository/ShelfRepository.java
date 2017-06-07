package io.altar.jseproject.Repository;

import java.util.ArrayList;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class ShelfRepository extends EntityRepository <Shelf>{

	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	private ShelfRepository(){}
	
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}

	
//Indentificar elementos do produto a alterar (ver shelf.java)

		public static void getShelfElem(int id){
			int codigo = ((Shelf)ShelfRepository.getInstance().get(id)).getCod();
			int capacidade = ((Shelf)ShelfRepository.getInstance().get(id)).getCap();
			int produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
			double preco = ((Shelf)ShelfRepository.getInstance().get(id)).getPreco();
			TextInterface.prodEdit(id, codigo, capacidade, produto, preco);
			};	
		
//Indentificar elementos da shelf para ver detalhes (ver shelf.java para vars, metodo chamado na textInterface.java)

		public static void getShelfDet(int id){
			int codigo = ((Shelf)ShelfRepository.getInstance().get(id)).getCod();
			double capacidade = ((Shelf)ShelfRepository.getInstance().get(id)).getCap();
			int produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
			double preco = ((Shelf)ShelfRepository.getInstance().get(id)).getPreco();
			TextInterface.printDetails(id, codigo, capacidade, produto, preco);
			};	
		
			
//substituir ou adicionar as caraterisiticas no Linked hash map (veio da TextInterface.java)	
		
		public static void alterShelfElement(int id,int codigo, int capacidade, int produto, double preco) {
			((Shelf)ShelfRepository.getInstance().get(id)).setCod(codigo);
			((Shelf)ShelfRepository.getInstance().get(id)).setCap(capacidade);
			((Shelf)ShelfRepository.getInstance().get(id)).setProd(produto);
			((Shelf)ShelfRepository.getInstance().get(id)).setPreco(preco);
		}

		
//Print valores da tabela da shelf
		
		public static void valShelf(){
			for(int eq = 1; eq<=getEntityList().size(); eq++ ){
				 int id = eq;
				 
				 int codigo = ((Shelf)ShelfRepository.getInstance().get(id)).getCod();
					double capacidade = ((Shelf)ShelfRepository.getInstance().get(id)).getCap();
					int produto = ((Shelf)ShelfRepository.getInstance().get(id)).getProd();
					double preco = ((Shelf)ShelfRepository.getInstance().get(id)).getPreco();
					
				TextInterface.printProductVal(id, codigo, capacidade, produto, preco);
				 
				}

		}	
		
}
