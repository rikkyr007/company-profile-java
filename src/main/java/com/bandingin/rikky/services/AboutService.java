package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.About;
import com.bandingin.rikky.repositories.AboutRepository;

@Service("aboutService")
public class AboutService {
	@Autowired
	AboutRepository aboutRepository;
	
	public Iterable<About> getAll(){
		return aboutRepository.findAll();
	}
	
	public DataTablesOutput<About> listAll(DataTablesInput input){
		return aboutRepository.findAll(input);
	}
	
	public About getByStatus(Integer status) {
		try {
			throw new ResourceNotFoundException("About Settings", "Status not found", status);
		}catch(Exception e) {
			return aboutRepository.findByStatus(status);
		}
	}
	
	public About insert(About banner) {
		return aboutRepository.save(banner);
	}
	
	public Optional<About> getById(Integer id){
		return aboutRepository.findById(id);
	}
	
	public About update(Integer status, About about) {
		About at = aboutRepository.findByStatus(status);
		if(at != null) {
		at.setAbout_description(about.getAbout_description());
		at.setStatus(about.getStatus());
		About update = aboutRepository.save(at);
		return update;
		}else {
			throw new ResourceNotFoundException("About", "Status not found", at.getStatus());
		}
	}
	public ResponseEntity<?> delete(Integer id){
		aboutRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
