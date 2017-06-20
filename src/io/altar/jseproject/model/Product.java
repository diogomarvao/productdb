package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class Product extends Entity {
		private static ProductRepository productList = ProductRepository.getInstance();
		private static ShelfRepository shelfList = ShelfRepository.getInstance();

		private ArrayList<Integer> pratIdLoc= new ArrayList<>();
		private double desconto;
		private int iva;
		private double pvp;		

//setters das variaveis
		
		public void setPratIdLoc(ArrayList<Integer> shelfIdLocation){
			this.pratIdLoc = pratIdLoc;
		}
		
		public void setDesconto(double desconto){
			this.desconto=desconto;
		}
		
		public void setIva(int iva){
			this.iva=iva;
		}
		
		public void setPvp(double pvp){
			this.pvp=pvp;
		}
		
//getters das variaveis
		
		public ArrayList<Integer> getPratIdLoc(){
			return this.pratIdLoc;
		}

		public double getDesconto(){
			return this.desconto;
		}
		
		public int getIva(){
			return this.iva;
		}
		
		public double getPvp(){
			return this.pvp;
		}
		

//	Adicionar produtos nas prateleiras
		
		public ArrayList<Integer> addToPrat(Scanner dados, int idPrat, int id){
			
			
			boolean morePrat = false;
			
			while (morePrat != true){
				
				if(((Shelf)shelfList.get(idPrat)).getProd() == null){
					pratIdLoc.add(idPrat);
					
//					Integer produto = id;
//				((Shelf)shelfList.get(idPrat)).setProd(produto);
//				
				} else {
					System.out.println("A prateleira ja tem um produto associado");
				}
			
				
				System.out.println("Deseja associar o produto a outra Prateleira? \n 1-> Sim\n 2->Nao");
				int menuinp = Utils.getMenuInp(1, 2);
				
				switch(menuinp){
					case 1:
						System.out.println("Indique a prateleira que pretende inserir o produto: ");
						idPrat=dados.nextInt();
						break;
						
					case 2:
						morePrat = true;
						break;
				}
			}
			return getPratIdLoc();
			
		}
		
//	Editar o produto na prateleira	
		public ArrayList<Integer> editProdPrat(Scanner dados, int id){
			
			for(Integer p : pratIdLoc){
				
				System.out.print(p + " -> ");
				p = Utils.getSkipDel(dados, id);
				
			}
			
			return pratIdLoc;
			
		}
		

//adicionar a parteleira criada ao repositorio shelfRepository

		public Product(ArrayList<Integer> pratIdLoc, double desconto, int iva, double pvp) {
			this.pratIdLoc = pratIdLoc;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			productList.addToList(this);
		}

		
//		Eliminar produtos (chamado na TextInterface.java)
		
		public static void delElemP(int id){
			int input = Utils.getMenuInp(1, 2);
			switch(input){
			case 1:
//				O produto � morto na EntityRepository.java
				productList.removElem(id);
				
				
				for(Integer p : ShelfRepository.getInstance().keySet()){
					
					Integer produto = ((Shelf)ShelfRepository.getInstance().get(p)).getProd();
					
					if(id == produto){
						
						produto = null;
						
					}
					
				}
	
				TextInterface.prodmenu();
				break;
			case 2:
				TextInterface.prodmenu();
				break;
			}
		}
		
//inputs de id
		public static int inputIdProd(){
			Scanner getIdInp = new Scanner(System.in);
			
			int id = 0;
			
			boolean valid = false;
			while (!valid){
				while(!getIdInp.hasNextInt()){
					System.out.println("por favor introduza um caracter numerico");
					getIdInp.next();
				}
				id	= getIdInp.nextInt();
			if(id<0 || id>productList.getEntityList().size()){
					System.out.println("Insira um valor entre " + 1 + " e " + productList.getEntityList().size() );
				}else{
					valid = true;
				}	
			}
			return id;
		
		}
		
}
		