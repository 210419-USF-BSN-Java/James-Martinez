package com.revature.models;

public class Product extends Inventory{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productId;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String size, String description, float price, int stock, String productId) {
		super(name, size, description, price, stock);
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", toString()=" + super.toString() + "]";
	}
	
	

}
