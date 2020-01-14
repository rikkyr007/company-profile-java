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

@Service("websitesettingService")
public class WebSettingsService {
	@Autowired
	WebSettingsRepository webSettingsRepository;
	
	public Iterable<WebSettings> getAll(){
		return webSettingsRepository.findAll();
	}
	
	public  DataTablesOutput<WebSettings> listAll(DataTablesInput input){
		return webSettingsRepository.findAll(input);
	}
	
	public WebSettings getByStatus(Integer status) {
		try {
			throw new ResourceNotFoundException("Web Settings", "Status not found", status);
		}catch(Exception e) {
			return webSettingsRepository.findByStatus(status);
		}
	}
	
	public WebSettings insert(WebSettings websitesetting) {
		return webSettingsRepository.save(websitesetting);
	}
	
	public Optional<WebSettings> getById(Integer id){
		return webSettingsRepository.findById(id);
	}
	
	public WebSettings update(Integer code, WebSettings websettings) {
		WebSettings ws = webSettingsRepository.findByStatus(code);
		if(ws != null) {
		ws.setWeb_tittle(websettings.getWeb_tittle());
		ws.setLogo_fb(websettings.getLogo_fb());
		ws.setLogo_twitter(websettings.getLogo_twitter());
		ws.setLogo_instagram(websettings.getLogo_instagram());
		ws.setCopyright(websettings.getCopyright());
		ws.setNo_telp(websettings.getNo_telp());
		ws.setNo_fax(websettings.getNo_fax());
		ws.setEmail(websettings.getEmail());
		ws.setAddress(websettings.getAddress());
		ws.setStatus(websettings.getStatus());
		WebSettings update = webSettingsRepository.save(ws);
		return update;
		}else {
			throw new ResourceNotFoundException("WebsiteSetting", "Status not found", ws.getStatus());
		}
	}
	
	public ResponseEntity<?> delete(Integer id){
		webSettingsRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
