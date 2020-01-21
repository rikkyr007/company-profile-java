package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.Foodpedia;
import com.bandingin.rikky.repositories.FoodpediaRepository;

@Service("foodpediaService")
public class FoodpediaService {
	@Autowired
	FoodpediaRepository foodpediaRepository;
	
	public Iterable<Foodpedia> getAll(){
		return foodpediaRepository.findAll();
	}
	
	public DataTablesOutput<Foodpedia> listAll(DataTablesInput input){
		return foodpediaRepository.findAll(input);
	}
	
	public Foodpedia insert(Foodpedia foodpedia) {
		return foodpediaRepository.save(foodpedia);
	}
	
	public Optional<Foodpedia> getById(Integer id){
		return foodpediaRepository.findById(id);
	}
	
	public Foodpedia update(Integer id, Foodpedia foodpedia) {
		Foodpedia fp = foodpediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		fp.setFoodpedia_title(foodpedia.getFoodpedia_title());
		fp.setFoodpedia_description(foodpedia.getFoodpedia_description());
		fp.setFoodpedia_image1(foodpedia.getFoodpedia_image1());
		fp.setFoodpedia_image2(foodpedia.getFoodpedia_image2());
		fp.setFoodpedia_desctag1(foodpedia.getFoodpedia_desctag1());
		fp.setFoodpedia_desctag2(foodpedia.getFoodpedia_desctag2());
		fp.setFoodpedia_tagimage1(foodpedia.getFoodpedia_tagimage1());
		fp.setFoodpedia_tagimage2(foodpedia.getFoodpedia_tagimage2());
		Foodpedia update = foodpediaRepository.save(fp);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		foodpediaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
