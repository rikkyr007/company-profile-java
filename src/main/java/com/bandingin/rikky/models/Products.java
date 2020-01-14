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
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Products implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "product_name", length = 25)
    @JsonView(DataTablesOutput.View.class)
    private String product_name;
	
	@Column(name = "product_description", length = 500)
    @JsonView(DataTablesOutput.View.class)
    private String product_description;
	
	@Column(name = "product_price", length = 11)
    @JsonView(DataTablesOutput.View.class)
    private String product_price;
	
	@Column(name = "product_image", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String product_image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProducts_image() {
		return product_image;
	}

	public void setProducts_image(String products_image) {
		this.product_image = products_image;
	}
	
	
}
