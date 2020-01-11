package com.bandingin.rikky.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandingin.rikky.models.Products;
import com.bandingin.rikky.services.ProductsService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductsController {
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/list/product")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Products> listAll(@Valid DataTablesInput input){
		return productsService.listAll(input);
	}
	
	@GetMapping("/product")
	public Iterable<Products> getAll(){
		return productsService.getAll();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Products> getById(@PathVariable("id") Integer id){
		return productsService.getById(id);
	}
	
	@PostMapping("/product")
	public Products insert(@RequestBody Products ws) {
		return productsService.insert(ws);
	}
	
	@PutMapping("/product/{id}")
	public Products update(@PathVariable("id") Integer id, @RequestBody Products ps) {
		return productsService.update(id, ps);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return productsService.delete(id);
	}

}
