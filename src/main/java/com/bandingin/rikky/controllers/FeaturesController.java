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

import com.bandingin.rikky.models.Features;
import com.bandingin.rikky.services.FeaturesService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FeaturesController {

	@Autowired
	FeaturesService featuresService;
	
	@GetMapping("/list/feature")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Features> listAll(@Valid DataTablesInput input){
		return featuresService.listAll(input);
	}
	
	@GetMapping("/feature")
	public Iterable<Features> getAll(){
		return featuresService.getAll();
	}
	
	@GetMapping("/feature/{id}")
	public Optional<Features> getById(@PathVariable("id") Integer id){
		return featuresService.getById(id);
	}
	
	@PostMapping("/feature")
	public Features insert(@RequestBody Features ws) {
		return featuresService.insert(ws);
	}
	
	@PutMapping("/feature/{id}")
	public Features update(@PathVariable("id") Integer id, @RequestBody Features fs) {
		return featuresService.update(id, fs);
	}
	
	@DeleteMapping("/feature/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return featuresService.delete(id);
	}
}
