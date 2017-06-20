package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class EntityRepository<E extends Entity> {
	private LinkedHashMap <Integer, Entity> entityList = new LinkedHashMap<>();

//getter do entityList
	//Para fazer print o shelfRepository e o ProductRepository n conseguem ir buscar o entityList por 
	//ser privado, logo � necessario criar um getter para ter acesso (ver ProductRepository e 
	//ShelfRepository)
	public LinkedHashMap<Integer, Entity> getEntityList() {
		return entityList;
	}
	
	public void setEntityList(LinkedHashMap<Integer, Entity> entityList) {
		this.entityList = entityList;
	}

	
//metodo para gerar o id automaticamente
	private int id = 0;
		
	public int getNextId(){	
		return ++id;
	}
	
	
//Indentificar Ids
	//Receber todos os Ids da lista   (vai servir principalmente para inndentificar a 
//										quantidade de shelfs e products no entityList)
		public Set<Integer> keySet(){
			return entityList.keySet();
	}
	
	//Verificar se a lista esta vazia	(utilizado para verificar a existencia de produtos
//											ou parteleiras durante a cria�ao dos mesmos)
		public boolean isEmpty(){
			return entityList.isEmpty();
	}
		
	//Receber o id do elemento da lista
		public Entity get(int id){
			return entityList.get(id);
		}
		
//		public Collection<Entity> teste(){
//			return entityList.values();
//		}

		
//Metodo para adicionar o elemento � lista	(ver Product.java e Shelf.java)
	public void addToList(Entity entity){
		entity.setId(getNextId());
		entityList.put(entity.getId(), entity);
		System.out.println(entityList.size());
	}
	
		
// delete do elemento
	public void removElem(int id){
		
			entityList.remove(id);
					
	}	
	
}	


