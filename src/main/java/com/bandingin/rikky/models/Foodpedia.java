package com.bandingin.rikky.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "foodpedia_management")
@EntityListeners(AuditingEntityListener.class)
public class Foodpedia implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "foodpedia_title", length = 25)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_title;
	
	@Column(name = "foodpedia_description", length = 500)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_description;
	
	@Column(name = "foodpedia_desctag1", length = 500)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_desctag1;
	
	@Column(name = "foodpedia_desctag2", length = 500)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_desctag2;
	
	@Column(name = "foodpedia_image1", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_image1;
	
	@Column(name = "foodpedia_image2", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_image2;
	
	@Column(name = "foodpedia_tagimage1", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_tagimage1;
	
	@Column(name = "foodpedia_tagimage2", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String foodpedia_tagimage2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodpedia_title() {
		return foodpedia_title;
	}

	public void setFoodpedia_title(String foodpedia_title) {
		this.foodpedia_title = foodpedia_title;
	}

	public String getFoodpedia_description() {
		return foodpedia_description;
	}

	public void setFoodpedia_description(String foodpedia_description) {
		this.foodpedia_description = foodpedia_description;
	}

	public String getFoodpedia_desctag1() {
		return foodpedia_desctag1;
	}

	public void setFoodpedia_desctag1(String foodpedia_desctag1) {
		this.foodpedia_desctag1 = foodpedia_desctag1;
	}

	public String getFoodpedia_desctag2() {
		return foodpedia_desctag2;
	}

	public void setFoodpedia_desctag2(String foodpedia_desctag2) {
		this.foodpedia_desctag2 = foodpedia_desctag2;
	}

	public String getFoodpedia_image1() {
		return foodpedia_image1;
	}

	public void setFoodpedia_image1(String foodpedia_image1) {
		this.foodpedia_image1 = foodpedia_image1;
	}

	public String getFoodpedia_image2() {
		return foodpedia_image2;
	}

	public void setFoodpedia_image2(String foodpedia_image2) {
		this.foodpedia_image2 = foodpedia_image2;
	}

	public String getFoodpedia_tagimage1() {
		return foodpedia_tagimage1;
	}

	public void setFoodpedia_tagimage1(String foodpedia_tagimage1) {
		this.foodpedia_tagimage1 = foodpedia_tagimage1;
	}

	public String getFoodpedia_tagimage2() {
		return foodpedia_tagimage2;
	}

	public void setFoodpedia_tagimage2(String foodpedia_tagimage2) {
		this.foodpedia_tagimage2 = foodpedia_tagimage2;
	}
	
	
	
}
