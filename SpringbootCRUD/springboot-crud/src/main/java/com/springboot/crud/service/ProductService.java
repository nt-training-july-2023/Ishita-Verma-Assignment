package com.springboot.crud.service;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.entity.Product;
import com.springboot.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//Post methods
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//Get methods
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	//Delete Product
	
	public String deleteProduct(int id) {
		  repository.deleteById(id);
		  return "REMOVED :" + id;
	}
	
	//Update Product-id cannot be modified so get the product
	//through id and then modify the existing product.
	
	public Product updateProduct(Product product) {
		Product preProduct = repository.findById(product.getId()).orElse(null);
		preProduct.setName(product.getName());
		preProduct.setQuantity(product.getQuantity());
		preProduct.setPrice(product.getPrice());
		return repository.save(preProduct);
	}
	
	
	
}
