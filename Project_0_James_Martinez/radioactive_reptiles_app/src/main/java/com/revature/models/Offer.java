package com.revature.models;

import java.sql.Date;

public class Offer extends Payment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int offerId;
	private String status;

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(int customerId, String name, float amount, Date dateTime, int offerId, String status) {
		super(customerId, name, amount, dateTime);
		this.offerId = offerId;
		this.status = status;
		
		// TODO Auto-generated constructor stub
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + offerId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Offer other = (Offer) obj;
		if (offerId != other.offerId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", status=" + status + ", toString()=" + super.toString() + "]";
	}

	

	

}
