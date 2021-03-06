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

import com.bandingin.rikky.models.WebSettings;
import com.bandingin.rikky.services.WebSettingsService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class WebSettingsController {
	@Autowired
	WebSettingsService websettingsService;
	
	@GetMapping("/list/websettings")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<WebSettings> listAll(@Valid DataTablesInput input){
		return websettingsService.listAll(input);
	}
	
	@GetMapping("/websettings")
	public Iterable<WebSettings> getAll(){
		return websettingsService.getAll();
	}
	
	@GetMapping("/websettings/{id}")
	public Optional<WebSettings> getById(@PathVariable("id") Integer id){
		return websettingsService.getById(id);
	}
	
	@GetMapping("/websetting/{status}")
	public WebSettings getByStatus(@PathVariable("status") Integer status) {
		return websettingsService.getByStatus(status);
	}
	
	@PostMapping("/websetting")
	public WebSettings insert (@RequestBody WebSettings websettings) {
		return websettingsService.insert(websettings);
	}
	
	@PutMapping("/websetting/{status}")
	public WebSettings update(@PathVariable("status") Integer status, @RequestBody WebSettings websitesetting) {
		return websettingsService.update(status, websitesetting);
	}
	
	@DeleteMapping("/websetting/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return websettingsService.delete(id);
	}
}
