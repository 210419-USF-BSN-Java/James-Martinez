package com.revature.service;

import com.revature.exception.InventoryException;
import com.revature.models.Mutation;

public interface MutationService {
	
	public int addMutation(Mutation mutation, String description) throws InventoryException;
	public int deleteMutationById(String mutationId) throws InventoryException;
	public int editMutationById(String mutationId, int choice, String update) throws InventoryException;
	
	public Mutation getMutationById(String mutationId) throws InventoryException;
	

}
