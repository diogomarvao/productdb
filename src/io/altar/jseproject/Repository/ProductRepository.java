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
	
//Criar o produto na lista
	

//Indentificar elementos do produto a alterar (ver produtos.java)

	public static void getProdElem(int id){
		int prat = ((Product)ProductRepository.getInstance().get(id)).getPrat();
		double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
		int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
		double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
		TextInterface.prodEdit(id, prat, desconto, iva, pvp);
		};	
	
//Indentificar elementos do produtopara ver detalhes (ver produtos.java para vars, metodo chamado na textInterface.java)

	public static void getProdDet(int id){
		int prat = ((Product)ProductRepository.getInstance().get(id)).getPrat();
		double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
		int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
		double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
		TextInterface.printDetails(id, prat, desconto, iva, pvp);
		};	
	
		
//	substituir ou adicionar as caraterisiticas no Linked hash map (veio da TextInterface.java)	
	
	public static void alterElement(int id,int prat, double desconto, int iva, double pvp) {

		((Product)ProductRepository.getInstance().get(id)).setPrat(prat);
		((Product)ProductRepository.getInstance().get(id)).setDesconto(desconto);
		((Product)ProductRepository.getInstance().get(id)).setIva(iva);
		((Product)ProductRepository.getInstance().get(id)).setPvp(pvp);
	}
	
}
