package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.Products;
import com.bandingin.rikky.repositories.ProductsRepository;

@Service("productsService")
public class ProductsService {
	@Autowired
	ProductsRepository productsRepository;

	public Iterable<Products> getAll(){
		return productsRepository.findAll();
	}
	
	public DataTablesOutput<Products> listAll(DataTablesInput input){
		return productsRepository.findAll(input);
	}
	
	public Products insert(Products products) {
		return productsRepository.save(products);
	}
	
	public Optional<Products> getById(Integer id){
		return productsRepository.findById(id);
	}
	
	public Products update(Integer id, Products products) {
		Products ps = productsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		ps.setProduct_name(products.getProduct_name());
		ps.setProduct_description(products.getProduct_description());
		ps.setProduct_price(products.getProduct_price());
		ps.setProducts_image(products.getProducts_image());
		Products update = productsRepository.save(ps);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		productsRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
