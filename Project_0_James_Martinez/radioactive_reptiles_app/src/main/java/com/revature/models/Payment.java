package com.revature.models;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private int customerId;
	private String name;
	private float amount;
	private Date dateTime;
	
	public Payment() {
		
	}

	public Payment(int customerId, String name, float amount, Date dateTime) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + customerId;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (customerId != other.customerId)
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-18s\t%-16s\t%-18s\t%-17s", "Customer ID:"+customerId, name, "Amount: $"+amount, dateTime);
	}
	

	
	
	

}
