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
@Table(name = "web_settings")
@EntityListeners(AuditingEntityListener.class)
public class WebSettings implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "menu_name", length = 25)
    @JsonView(DataTablesOutput.View.class)
    private String menu_name;
	
	@Column(name = "menu_link", length = 100)
    @JsonView(DataTablesOutput.View.class)
    private String menu_link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_link() {
		return menu_link;
	}

	public void setMenu_link(String menu_link) {
		this.menu_link = menu_link;
	}
	
	
}
