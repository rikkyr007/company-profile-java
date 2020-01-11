package com.bandingin.rikky.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.rikky.models.Products;

public interface ProductsRepository extends DataTablesRepository<Products, Integer>{

}
