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

import com.bandingin.rikky.models.MenuSettings;
import com.bandingin.rikky.services.MenuSettingsService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MenuSettingsController {

	@Autowired
	MenuSettingsService menuSettingsService;
	
	@GetMapping("/list/menu")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<MenuSettings> listAll(@Valid DataTablesInput input){
		return menuSettingsService.listAll(input);
	}
	
	@GetMapping("/menu")
	public Iterable<MenuSettings> getAll(){
		return menuSettingsService.getAll();
	}
	
	@GetMapping("/menu/{id}")
	public Optional<MenuSettings> getById(@PathVariable("id") Integer id){
		return menuSettingsService.getById(id);
	}
	
	@PostMapping("/menu")
	public MenuSettings insert(@RequestBody MenuSettings ws) {
		return menuSettingsService.insert(ws);
	}
	
	@PutMapping("/menu/{id}")
	public MenuSettings update(@PathVariable("id") Integer id, @RequestBody MenuSettings ws) {
		return menuSettingsService.update(id, ws);
	}
	
	@DeleteMapping("/menu/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return menuSettingsService.delete(id);
	}
}
