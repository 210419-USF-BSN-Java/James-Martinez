package com.revature.service.impl;

import com.revature.dao.MutationDAO;
import com.revature.dao.impl.MutationDAOImpl;
import com.revature.exception.InventoryException;
import com.revature.models.Mutation;
import com.revature.service.MutationService;

public class MutationServiceImpl implements MutationService{
	
	private MutationDAO muteDAO = new MutationDAOImpl();

	@Override
	public int addMutation(Mutation mutation, String description) throws InventoryException {
		
		if(!MutationValidations.isValidMutationId(mutation.getMutationId())) {
			throw new InventoryException("Invalid Mutation ID format please try again");
		}
		if(!MutationValidations.isValidMutationName(mutation.getName())) {
			throw new InventoryException("Invalid Name format must be between 5-30 characters and spaces only");
		}
		if(!MutationValidations.isValidMutationHeight(mutation.getHeight())) {
			throw new InventoryException("Invalid height format must be between 5-15 characters");
		}
		if(!MutationValidations.isValidMutationWeight(mutation.getWeight())) {
			throw new InventoryException("Invalid weight format must be between 5-15 characters");
		}
		if(!MutationValidations.isValidMutationPrice(mutation.getAskPrice())) {
			throw new InventoryException("Ask price must be greater than 0");
		}
		if(!MutationValidations.isValidMutationDescription(description)) {
			throw new InventoryException("Description cannot be empty and cannot exceed 150 characters");
		}
		return muteDAO.addMutation(mutation, description);
	}

	@Override
	public int deleteMutationById(String mutationId) throws InventoryException {
		if(!MutationValidations.isValidMutationId(mutationId)) {
			throw new InventoryException("The ID "+mutationId+" is invalid please try again");
		}
		return muteDAO.deleteMutationById(mutationId);
	}

	@Override
	public int editMutationById(String mutationId, int choice, String update) throws InventoryException {
		if(!MutationValidations.isValidMutationId(mutationId)) {
			throw new InventoryException("The ID "+mutationId+" is invalid please try again");
		}
		return muteDAO.editMutationById(mutationId, choice, update);
	}


	@Override
	public Mutation getMutationById(String mutationId) throws InventoryException {
		if(!MutationValidations.isValidMutationId(mutationId)) {
			throw new InventoryException("The ID "+mutationId+" is invalid please try again");
		}
		return muteDAO.getMutationById(mutationId);
	}

}
