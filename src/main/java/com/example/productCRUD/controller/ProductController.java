package com.example.productCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.productCRUD.domain.product.Product;
import com.example.productCRUD.domain.product.ProductRepository;
import com.example.productCRUD.domain.product.RequestProduct;
import jakarta.validation.Valid;
import lombok.val;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> allProducts = repository.findAll();
		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data){
		
		Product newProduct = new Product(data);
		repository.save(newProduct);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data) {
		
		Product product = repository.getReferenceById(data.id());
		product.setName(data.name());
		product.setPrice_in_cents(data.price_in_cents());
		return ResponseEntity.ok(product);
		
	}
	
	
}
