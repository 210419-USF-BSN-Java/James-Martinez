package com.revature.models;

import java.sql.Date;

public class Purchase extends Payment{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float balance;
	private int purchaseId;
	
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Purchase(int customerId, String name, float amount, Date dateTime, int purchaseId, float balance) {
		super(customerId, name, amount, dateTime);
		this.purchaseId = purchaseId;
		this.balance = balance;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	public int getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + purchaseId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (purchaseId != other.purchaseId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Purchase [balance=" + balance + ", purchaseId=" + purchaseId + "]";
	}
	
	

}
