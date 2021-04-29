package com.revature.service;

import java.util.List;

import com.revature.exception.InventoryException;
import com.revature.models.Product;

public interface ProductService {
	
	public int addProduct(Product product) throws InventoryException;
	public int deleteProductById(String productId) throws InventoryException;
	public int editProductById(String productId) throws InventoryException;
	
}
