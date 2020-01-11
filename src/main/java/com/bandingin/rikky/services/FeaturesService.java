package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.Features;
import com.bandingin.rikky.repositories.FeaturesRepository;

@Service("featuresService")
public class FeaturesService {
	@Autowired
	FeaturesRepository featuresRepository;

	public Iterable<Features> getAll(){
		return featuresRepository.findAll();
	}
	
	public DataTablesOutput<Features> listAll(DataTablesInput input){
		return featuresRepository.findAll(input);
	}
	
	public Features insert(Features websettings) {
		return featuresRepository.save(websettings);
	}
	
	public Optional<Features> getById(Integer id){
		return featuresRepository.findById(id);
	}
	
	public Features update(Integer id, Features features) {
		Features fs = featuresRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		fs.setFeature_name(features.getFeature_name());
		fs.setFeature_description(features.getFeature_description());
		fs.setFeature_image(features.getFeature_image());
		Features update = featuresRepository.save(fs);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		featuresRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
