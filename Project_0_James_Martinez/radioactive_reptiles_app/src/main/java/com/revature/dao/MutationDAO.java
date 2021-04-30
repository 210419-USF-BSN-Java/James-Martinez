package com.revature.dao;

import java.util.List;

import com.revature.exception.InventoryException;
import com.revature.models.Mutation;

public interface MutationDAO {
	
	public int addMutation(Mutation mutation) throws InventoryException;
	public int deleteMutationById(String mutationId) throws InventoryException;
	public int editMutationById(String mutationId) throws InventoryException;
	
	public List<Mutation> listMutationByType(String mutationId) throws InventoryException;
	
	public String getMutationDescription(int mutationid);
	public int setMutationDescription(String description) throws InventoryException;
	public Mutation getMutationById(String mutationId) throws InventoryException;

}
