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
		ArrayList<Integer> pratIdLoc = ((Product)ProductRepository.getInstance().get(id)).getPratIdLoc();
		double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
		int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
		double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
		TextInterface.prodEdit(id, pratIdLoc, desconto, iva, pvp);
		};	
	
//Indentificar elementos do produto para ver detalhes (ver produtos.java para vars, metodo chamado na textInterface.java)
 
	public static void getProdDet(int id){
		int prat =0;
//		int prat = ((Product)ProductRepository.getInstance().get(id)).getPrat();
		double desconto = ((Product)ProductRepository.getInstance().get(id)).getDesconto();
		int iva = ((Product)ProductRepository.getInstance().get(id)).getIva();
		double pvp = ((Product)ProductRepository.getInstance().get(id)).getPvp();
		TextInterface.printDetails(id, prat, desconto, iva, pvp);
		TextInterface.prodmenu();
		};	
	
		
//	substituir ou adicionar as caraterisiticas no Linked hash map (chamado na TextInterface.java)	
	
	public static void alterProdElement(int id,ArrayList<Integer> pratIdLoc, double desconto, int iva, double pvp) {
		((Product)ProductRepository.getInstance().get(id)).setPratIdLoc(pratIdLoc);
		((Product)ProductRepository.getInstance().get(id)).setDesconto(desconto);
		((Product)ProductRepository.getInstance().get(id)).setIva(iva);
		((Product)ProductRepository.getInstance().get(id)).setPvp(pvp);
	}	
	
//Print valores da tabela do prod (chamado na TextInterface.java)
	public static void valProduct(){
//											keySet() -> ver EntityRepository
		for (Integer id : getInstance().keySet()) {
//		 retirar os valores das variaveis por cada id		 
			int prat=0;
			
//			System.out.println(ProductRepository.getInstance().teste());
			
//			=((Product)ProductRepository.getInstance().get(id)).getPrat();
			Product p = (Product)ProductRepository.getInstance().get(id);
			double desconto = p.getDesconto();
			int iva = p.getIva();
			double pvp = p.getPvp();
//																		Envia os valores para a TextInterface serem inpressos 
			TextInterface.printProductVal(id, prat, desconto, iva, pvp);
			 
			}
	
	}
			
}
