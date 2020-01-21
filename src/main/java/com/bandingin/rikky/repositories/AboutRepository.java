package com.bandingin.rikky.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.rikky.models.About;

public interface AboutRepository extends DataTablesRepository<About, Integer>{
	About findByStatus(Integer status);
}
