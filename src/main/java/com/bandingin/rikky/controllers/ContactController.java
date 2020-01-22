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

import com.bandingin.rikky.models.Contact;
import com.bandingin.rikky.services.ContactsService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ContactController {
	@Autowired
	ContactsService contactsService;
	
	@GetMapping("/list/contact")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Contact> listAll(@Valid DataTablesInput input){
		return contactsService.listAll(input);
	}
	
	@GetMapping("/contact")
	public Iterable<Contact> getAll(){
		return contactsService.getAll();
	}
	
	@GetMapping("/contact/{id}")
	public Optional<Contact> getById(@PathVariable("id") Integer id){
		return contactsService.getById(id);
	}
	
	@PostMapping("/contact")
	public Contact insert(@RequestBody Contact ct) {
		return contactsService.insert(ct);
	}
	
	@PutMapping("/contact/{id}")
	public Contact update(@PathVariable("id") Integer id, @RequestBody Contact ct) {
		return contactsService.update(id, ct);
	}
	
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return contactsService.delete(id);
	}
}
