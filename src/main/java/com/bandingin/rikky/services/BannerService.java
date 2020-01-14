package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.Banner;
import com.bandingin.rikky.repositories.BannerRepository;

@Service("bannerService")
public class BannerService {
	@Autowired
	BannerRepository bannerRepository;
	
	public Iterable<Banner> getAll(){
		return bannerRepository.findAll();
	}
	
	public DataTablesOutput<Banner> listAll(DataTablesInput input){
		return bannerRepository.findAll(input);
	}
	
	public Banner insert(Banner banner) {
		return bannerRepository.save(banner);
	}
	
	public Optional<Banner> getById(Integer id){
		return bannerRepository.findById(id);
	}
	
	public Banner update(Integer id, Banner banner) {
		Banner bn = bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		bn.setBanner_title(banner.getBanner_title());
		bn.setBanner_description(banner.getBanner_description());
		bn.setBanner_button_link(banner.getBanner_button_link());
		bn.setBanner_image(banner.getBanner_image());
		Banner update = bannerRepository.save(bn);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		bannerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
