package com.bandingin.rikky.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.rikky.models.Foodpedia;

public interface FoodpediaRepository extends DataTablesRepository<Foodpedia, Integer>{

}
