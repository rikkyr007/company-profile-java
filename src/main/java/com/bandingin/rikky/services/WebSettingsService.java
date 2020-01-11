package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.WebSettings;
import com.bandingin.rikky.repositories.WebSettingsRepository;

@Service("websettingsService")
public class WebSettingsService {
	@Autowired
	WebSettingsRepository websettingsRepository;

	public Iterable<WebSettings> getAll(){
		return websettingsRepository.findAll();
	}
	
	public DataTablesOutput<WebSettings> listAll(DataTablesInput input){
		return websettingsRepository.findAll(input);
	}
	
	public WebSettings insert(WebSettings websettings) {
		return websettingsRepository.save(websettings);
	}
	
	public Optional<WebSettings> getById(Integer id){
		return websettingsRepository.findById(id);
	}
	
	public WebSettings update(Integer id, WebSettings websettings) {
		WebSettings ws = websettingsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		ws.setMenu_name(websettings.getMenu_name());
		ws.setMenu_link(websettings.getMenu_link());
		WebSettings update = websettingsRepository.save(ws);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		websettingsRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
