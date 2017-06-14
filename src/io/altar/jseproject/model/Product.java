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
		
		public static ArrayList<Integer> addToPrat(Scanner dados, int id){
			int i=0;
//			pedir opiniao
			boolean newPrat = false;
			while(!newPrat){
				while(getPratIdLoc().get(i) == id){
					
					for(i=0; i<getPratIdLoc().size(); i++){
						if(getPratIdLoc().get(i) == id){
							System.out.println("Indique outra prateleira");
							id = dados.nextInt();
						}		
					}
					
				}
				getPratIdLoc().add(id);
				int menuinp = Utils.getMenuInp(1,2);
					switch(menuinp){
						case 1:
							newPrat=false; 
							id = dados.nextInt();
							break;
						case 2:
							newPrat = true;
							break;
					}
				
			}
			return getPratIdLoc();
		}
		
//	Editar o produto na prateleira	
		public static int editProdPrat(Scanner dados, int id){
			int i=0;
//			pedir opiniao
			while(getPratIdLoc().get(i) != id){
				
				for(i=0; i<getPratIdLoc().size(); i++){
					if(getPratIdLoc().get(i) == id){
						id = Utils.getSkipDel(dados, id);
						break;
					}		
				}
				
			}
			int idProd = id;
			return idProd;
			
		}


//adicionar a parteleira criada ao repositorio shelfRepository

		public Product(ArrayList<Integer> pratIdLoc, double desconto, int iva, double pvp) {
			this.pratIdLoc = pratIdLoc;
			this.desconto = desconto;
			this.iva = iva;
			this.pvp = pvp;
			ProductRepository.getInstance().addToList(this);
		}

		
//		Eliminar produtos (chamado na TextInterface.java)
		
		public static void delElemP(int id){
			int input = Utils.getMenuInp(1, 2);
			switch(input){
			case 1:
//				O produto � morto na EntityRepository.java
				ProductRepository.getInstance().removElem(id);
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
			if(id<0 || id>ProductRepository.getInstance().getEntityList().size()){
					System.out.println("Insira um valor entre " + 1 + " e " + ProductRepository.getInstance().getEntityList().size() );
				}else{
					valid = true;
				}	
			}
			return id;
		
		}
		
}
		