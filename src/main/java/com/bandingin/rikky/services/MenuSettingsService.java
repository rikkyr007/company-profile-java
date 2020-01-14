package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.MenuSettings;
import com.bandingin.rikky.repositories.MenuSettingsRepository;

@Service("menuSettingsService")
public class MenuSettingsService {
	@Autowired
	MenuSettingsRepository menuSettingsRepository;

	public Iterable<MenuSettings> getAll(){
		return menuSettingsRepository.findAll();
	}
	
	public DataTablesOutput<MenuSettings> listAll(DataTablesInput input){
		return menuSettingsRepository.findAll(input);
	}
	
	public MenuSettings insert(MenuSettings websettings) {
		return menuSettingsRepository.save(websettings);
	}
	
	public Optional<MenuSettings> getById(Integer id){
		return menuSettingsRepository.findById(id);
	}
	
	public MenuSettings update(Integer id, MenuSettings menusettings) {
		MenuSettings ms = menuSettingsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		ms.setMenu_name(menusettings.getMenu_name());
		ms.setMenu_link(menusettings.getMenu_link());
		MenuSettings update = menuSettingsRepository.save(ms);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		menuSettingsRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
