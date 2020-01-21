package com.bandingin.rikky.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.bandingin.rikky.models.About;
import com.bandingin.rikky.services.AboutService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AboutController {
	@Autowired
	AboutService aboutService;
	
	@GetMapping("/list/about")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<About> listAll(@Valid DataTablesInput input){
		return aboutService.listAll(input);
	}
	
	@GetMapping("/about")
	public Iterable<About> getAll(){
		return aboutService.getAll();
	}
	
	@GetMapping("/about/{id}")
	public Optional<About> getById(@PathVariable("id") Integer id){
		return aboutService.getById(id);
	}
	
	@GetMapping("/about/{status}")
	public About getByStatus(@PathVariable("status") Integer status) {
		return aboutService.getByStatus(status);
	}
	
	@PostMapping("/about")
	public About insert(@RequestBody About at) {
		return aboutService.insert(at);
	}
	
	@PutMapping("/about/{status}")
	public About update(@PathVariable("status") Integer status, @RequestBody About about) {
		return aboutService.update(status, about);
	}
	
	@DeleteMapping("/about/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return aboutService.delete(id);
	}
}
