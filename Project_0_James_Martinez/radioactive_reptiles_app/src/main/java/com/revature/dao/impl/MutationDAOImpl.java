package com.revature.dao.impl;

import java.util.List;

import com.revature.dao.MutationDAO;
import com.revature.exception.InventoryException;
import com.revature.models.Mutation;

public class MutationDAOImpl implements MutationDAO{

	@Override
	public int addMutation(Mutation mutation) throws InventoryException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMutationById(String mutationId) throws InventoryException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editMutationById(String mutationId) throws InventoryException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Mutation> listMutationByType(String mutationId) throws InventoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMutationDescription(int mutationid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setMutationDescription(String description) throws InventoryException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mutation getMutationById(String mutationId) throws InventoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
