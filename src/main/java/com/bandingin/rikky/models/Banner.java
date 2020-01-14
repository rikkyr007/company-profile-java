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
@Table(name = "banner_management")
@EntityListeners(AuditingEntityListener.class)
public class Banner {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name = "banner_title", length = 25)
    @JsonView(DataTablesOutput.View.class)
    private String banner_title;
	
	@Column(name = "banner_description", length = 50)
    @JsonView(DataTablesOutput.View.class)
    private String banner_description;
	
	@Column(name = "banner_button_link", length = 50)
    @JsonView(DataTablesOutput.View.class)
    private String banner_button_link;
	
	@Column(name = "banner_image", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String banner_image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBanner_title() {
		return banner_title;
	}

	public void setBanner_title(String banner_title) {
		this.banner_title = banner_title;
	}

	public String getBanner_description() {
		return banner_description;
	}

	public void setBanner_description(String banner_description) {
		this.banner_description = banner_description;
	}

	public String getBanner_button_link() {
		return banner_button_link;
	}

	public void setBanner_button_link(String banner_button_link) {
		this.banner_button_link = banner_button_link;
	}

	public String getBanner_image() {
		return banner_image;
	}

	public void setBanner_image(String banner_image) {
		this.banner_image = banner_image;
	}

	
	
}
