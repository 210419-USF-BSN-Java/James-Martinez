package com.revature.models;

import java.sql.Date;

public class Purchase extends Payment{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int customerid;
	private String productid;
	private String mutationid;
	private float balance;
	
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase(float amount, Date dateTime, int customerid, String productid, String mutationid, float balance) {
		super(amount, dateTime);
		this.customerid = customerid;
		this.productid = productid;
		this.mutationid = mutationid;
		this.balance = balance;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getMutationid() {
		return mutationid;
	}
	public void setMutationid(String mutationid) {
		this.mutationid = mutationid;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + customerid;
		result = prime * result + ((mutationid == null) ? 0 : mutationid.hashCode());
		result = prime * result + ((productid == null) ? 0 : productid.hashCode());
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
		if (customerid != other.customerid)
			return false;
		if (mutationid == null) {
			if (other.mutationid != null)
				return false;
		} else if (!mutationid.equals(other.mutationid))
			return false;
		if (productid == null) {
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sales [customerid=" + customerid + ", productid=" + productid + ", mutationid=" + mutationid
				+ ", balance=" + balance + ", toString()=" + super.toString() + "]";
	}
	
	

}
