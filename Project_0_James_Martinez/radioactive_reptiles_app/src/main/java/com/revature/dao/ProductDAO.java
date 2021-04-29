package com.revature.dao;

import java.util.List;

import com.revature.exception.InventoryException;
import com.revature.models.Product;

public interface ProductDAO {
	
	public int addProduct(Product product) throws InventoryException;
	public int deleteProductById(String productId) throws InventoryException;
	public int editProductById(String productId) throws InventoryException;
	
	public List<Product> listProductByType(String productId) throws InventoryException;

}
