package com.revature.dao;

import java.util.List;

import com.revature.exception.InventoryException;
import com.revature.models.Mutation;

public interface MutationDAO {
	
	public int addMutation(Mutation mutation, String description) throws InventoryException; //COMPLETED
	public int deleteMutationById(String mutationId) throws InventoryException; //COMPLETED 
	public int editMutationById(String mutationId, int choice, String update) throws InventoryException; //COMPLETED
	
	public List<Mutation> listMutationByType(String mutationId) throws InventoryException; //COMPLETED
	
	public String getMutationDescription(String mutationid); //COMPLETED
	
	public Mutation getMutationById(String mutationId) throws InventoryException; //COMPLETED? i think

}
