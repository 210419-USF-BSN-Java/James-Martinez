package com.revature.models;

import java.io.Serializable;

public class Mutation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mutationId;
	private String name;
	private String height;
	private String weight;
	private float askPrice;
	private int stock;
	
	public Mutation() {

	}

	public Mutation(String mutationId, String name, String height, String weight, float askPrice, int stock) {
		super();
		this.mutationId = mutationId;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.askPrice = askPrice;
		this.stock = stock;
	}

	public String getMutationId() {
		return mutationId;
	}

	public void setMutationId(String mutationId) {
		this.mutationId = mutationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public float getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(float askPrice) {
		this.askPrice = askPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(askPrice);
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((mutationId == null) ? 0 : mutationId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stock;
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		Mutation other = (Mutation) obj;
		if (Float.floatToIntBits(askPrice) != Float.floatToIntBits(other.askPrice))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (mutationId == null) {
			if (other.mutationId != null)
				return false;
		} else if (!mutationId.equals(other.mutationId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stock != other.stock)
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mutation [mutationId=" + mutationId + ", name=" + name + ", height=" + height + ", weight=" + weight
				+ ", askPrice=" + askPrice + ", stock=" + stock + "]";
	}
	

}
