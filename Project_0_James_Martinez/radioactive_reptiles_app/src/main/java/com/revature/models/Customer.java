package com.revature.models;

public class Customer extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String location;
	private int custId;

	public Customer() {
		super();
	}

	public Customer(String name, String email, String password, String location, int custId) {
		super(name, email, password);
		this.location = location;
		this.custId = custId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCustid() {
		return custId;
	}

	public void setCustid(int custId) {
		this.custId = custId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + custId;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		Customer other = (Customer) obj;
		if (custId != other.custId)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-8d", custId)+super.toString()+ String.format("%-25s", "Location: "+location);
	}

	

	


	
	
	
	
	
	
}
