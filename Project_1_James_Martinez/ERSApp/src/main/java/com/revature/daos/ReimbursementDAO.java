package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	public int createNewReimbursement(Reimbursement reimb, int typeId);
	
	public int updateReimbursementStatus(int reimbId, int statusId, int resoId);
	
	public List<Reimbursement> listReimbByIdandStatus(int id, String status);
	
	public List<Reimbursement> listAllPending();
	
	public List<Reimbursement> ListAllResolved(); //with manager

}
