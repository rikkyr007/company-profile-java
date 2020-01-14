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

import com.bandingin.rikky.models.Banner;
import com.bandingin.rikky.models.Features;
import com.bandingin.rikky.services.BannerService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BannerController {
	@Autowired
	BannerService bannerService;
	
	@GetMapping("/list/banner")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Banner> listAll(@Valid DataTablesInput input){
		return bannerService.listAll(input);
	}
	
	@GetMapping("/banner")
	public Iterable<Banner> getAll(){
		return bannerService.getAll();
	}
	
	@GetMapping("/banner/{id}")
	public Optional<Banner> getById(@PathVariable("id") Integer id){
		return bannerService.getById(id);
	}
	
	@PostMapping("/banner")
	public Banner insert(@RequestBody Banner bn) {
		return bannerService.insert(bn);
	}
	
	@PutMapping("/banner/{id}")
	public Banner update(@PathVariable("id") Integer id, @RequestBody Banner bn) {
		return bannerService.update(id, bn);
	}
	
	@DeleteMapping("/banner/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return bannerService.delete(id);
	}
}
