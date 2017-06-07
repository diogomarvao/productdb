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

//gerar ids	
	
	public static LinkedHashMap<Integer, Entity> getEntityList() {
		return entityList;
	}


	public static void setEntityList(LinkedHashMap<Integer, Entity> entityList) {
		EntityRepository.entityList = entityList;
	}

	private int id = 0;
		
	public int getNextId(){	
		return ++id;
	}

	
//Adicionar a lista	
	
	public void addToList(Entity entity){
		entity.setId(getNextId());
		entityList.put(entity.getId(), entity);
	}

//Receber o id do elemento
	
	public Entity get(int id){
		return entityList.get(id);
	}
	
// delete do elemento

	public static void removElem(int id){
		
			entityList.remove(id);
					
	}	
	
}	


