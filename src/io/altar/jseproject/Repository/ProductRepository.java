package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class ProductRepository extends EntityRepository<Product>{

	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository(){}
	
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	

//Indentificar elementos do produto a alterar (metodo chamado na TextInterface.java)

	public static void getProdElem(int id){
		int prat = ((Product)ProductRepository.getInstance().get(id)).getPrat();
		double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
		int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
		double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
		TextInterface.prodEdit(id, prat, desconto, iva, pvp);
		};	
	
//Indentificar elementos do produto para ver detalhes (ver produtos.java para vars, metodo chamado na textInterface.java)

	public static void getProdDet(int id){
		int prat = ((Product)ProductRepository.getInstance().get(id)).getPrat();
		double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
		int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
		double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
		TextInterface.printDetails(id, prat, desconto, iva, pvp);
		};	
	
		
//	substituir ou adicionar as caraterisiticas no Linked hash map (chamado na TextInterface.java)	
	
	public static void alterProdElement(int id,int prat, double desconto, int iva, double pvp) {
		((Product)ProductRepository.getInstance().get(id)).setPrat(prat);
		((Product)ProductRepository.getInstance().get(id)).setDesconto(desconto);
		((Product)ProductRepository.getInstance().get(id)).setIva(iva);
		((Product)ProductRepository.getInstance().get(id)).setPvp(pvp);
	}	
	
//Print valores da tabela do prod (chamado na TextInterface.java)
//																		getEntityList().size() ====> tamanho do LinkedHashMap
	public static void valProduct(){
		
		for(int eq = 1; eq<=ProductRepository.getEntityList().size(); eq++ ){
			 int id = eq;
//		 retirar os valores das variaveis por cada id		 
			int prat = ((Product)ProductRepository.getInstance().get(eq)).getPrat();
			double desconto = ((Product)ProductRepository.getInstance().get(eq)).getDesconto();
			int iva = ((Product)ProductRepository.getInstance().get(eq)).getIva();
			double pvp = ((Product)ProductRepository.getInstance().get(eq)).getPvp();
//																		Envia os valores para a TextInterface serem inpressos 
			TextInterface.printProductVal(id, prat, desconto, iva, pvp);
			 
			}
	
	}
			
}
