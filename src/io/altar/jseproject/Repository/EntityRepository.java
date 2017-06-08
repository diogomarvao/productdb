package io.altar.jseproject.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;
import io.altar.jseproject.util.Utils;

public class EntityRepository<E extends Entity> {
	private static LinkedHashMap <Integer, Entity> entityList = new LinkedHashMap<>();

//getter do entityList
	//Para fazer print o shelfRepository e o ProductRepository n conseguem ir buscar o entityList por 
	//ser privado, logo é necessario criar um getter para ter acesso (ver ProductRepository e 
	//ShelfRepository)
	public static LinkedHashMap<Integer, Entity> getEntityList() {
		return entityList;
	}
	
	public static void setEntityList(LinkedHashMap<Integer, Entity> entityList) {
		EntityRepository.entityList = entityList;
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
//											ou parteleiras durante a criaçao dos mesmos)
		public boolean isEmpty(){
			return entityList.isEmpty();
	}
		
	//Receber o id do elemento da lista
		public Entity get(int id){
			return entityList.get(id);
		}

		
//Metodo para adicionar o elemento à lista	(ver Product.java e Shelf.java)
	public void addToList(Entity entity){
		entity.setId(getNextId());
		entityList.put(entity.getId(), entity);
	}
	
		
// delete do elemento
	public static void removElem(int id){
		
			entityList.remove(id);
					
	}	
	
}	


