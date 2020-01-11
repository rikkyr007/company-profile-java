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
@Table(name = "features_management")
@EntityListeners(AuditingEntityListener.class)
public class Features implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "feature_name", length = 25)
    @JsonView(DataTablesOutput.View.class)
    private String feature_name;
	
	@Column(name = "feature_description", length = 500)
    @JsonView(DataTablesOutput.View.class)
    private String feature_description;
	
	@Column(name = "feature_image", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String feature_image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeature_name() {
		return feature_name;
	}

	public void setFeature_name(String feature_name) {
		this.feature_name = feature_name;
	}

	public String getFeature_description() {
		return feature_description;
	}

	public void setFeature_description(String feature_description) {
		this.feature_description = feature_description;
	}

	public String getFeature_image() {
		return feature_image;
	}

	public void setFeature_image(String feature_image) {
		this.feature_image = feature_image;
	}
}
