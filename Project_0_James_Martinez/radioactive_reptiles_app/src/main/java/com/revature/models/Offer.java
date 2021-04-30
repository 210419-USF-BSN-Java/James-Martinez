package com.revature.models;

import java.sql.Date;

public class Offer extends Payment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int offerId;
	private String mutationName;
	private String status;

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(int customerId, String name, float amount, Date dateTime) {
		super(customerId, name, amount, dateTime);
		// TODO Auto-generated constructor stub
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getMutationName() {
		return mutationName;
	}

	public void setMutationName(String mutationName) {
		this.mutationName = mutationName;
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
		result = prime * result + ((mutationName == null) ? 0 : mutationName.hashCode());
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
		if (mutationName == null) {
			if (other.mutationName != null)
				return false;
		} else if (!mutationName.equals(other.mutationName))
			return false;
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
		return "Offer [offerId=" + offerId + ", mutationName=" + mutationName + ", status=" + status + ", toString()="
				+ super.toString() + "]";
	}

	

}
