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
	private LinkedHashMap <Integer, Entity> entityList = new LinkedHashMap<>();

//gerar ids	
	
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
	
// delete produto

	public static void delElem(int id){
		int input = Utils.getMenuInp(1, 2);
		switch(input){
		case 1:
			entityList.remove(id);
			TextInterface.prodmenu();
			break;
		case 2:
			TextInterface.prodmenu();
			break;
		}
		
	}
	
}	


