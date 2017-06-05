package io.altar.jseproject.Repository;

import java.util.ArrayList;

import io.altar.jseproject.model.Shelf;

public class ShelfRepository extends EntityRepository{

	private static final ShelfRepository INSTANCE = new ShelfRepository();
	private ShelfRepository(){}
	
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}
	
}
