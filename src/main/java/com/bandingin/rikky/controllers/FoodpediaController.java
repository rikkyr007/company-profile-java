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

import com.bandingin.rikky.models.Foodpedia;
import com.bandingin.rikky.services.FoodpediaService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FoodpediaController {
	@Autowired
	FoodpediaService foodpediaService;
	
	@GetMapping("/list/foodpedia")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Foodpedia> listAll(@Valid DataTablesInput input){
		return foodpediaService.listAll(input);
	}
	
	@GetMapping("/foodpedia")
	public Iterable<Foodpedia> getAll(){
		return foodpediaService.getAll();
	}
	
	@GetMapping("/foodpedia/{id}")
	public Optional<Foodpedia> getById(@PathVariable("id") Integer id){
		return foodpediaService.getById(id);
	}
	
	@PostMapping("/foodpedia")
	public Foodpedia insert(@RequestBody Foodpedia fd) {
		return foodpediaService.insert(fd);
	}
	
	@PutMapping("/foodpedia/{id}")
	public Foodpedia update(@PathVariable("id") Integer id, @RequestBody Foodpedia fd) {
		return foodpediaService.update(id, fd);
	}
	
	@DeleteMapping("/foodpedia/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return foodpediaService.delete(id);
	}
}
