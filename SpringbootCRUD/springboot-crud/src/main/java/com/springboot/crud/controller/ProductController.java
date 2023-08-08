package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entity.Product;
import com.springboot.crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired 
	private ProductService service;  
	
	//post
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	//get
	@GetMapping("./products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/products/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	//put
	@PutMapping("/update")
	public Product update(Product product) {
		return service.saveProduct(product);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public String delete( @PathVariable int id) {
		return service.deleteProduct(id);
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

