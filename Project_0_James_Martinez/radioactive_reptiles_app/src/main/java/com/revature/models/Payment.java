package com.revature.models;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float amount;
	private Date dateTime;
	
	public Payment() {
		
	}

	public Payment(float amount, Date dateTime) {
		super();
		this.amount = amount;
		this.dateTime = dateTime;
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
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
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
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", dateTime=" + dateTime + "]";
	}
	
	
	
	
	

}
