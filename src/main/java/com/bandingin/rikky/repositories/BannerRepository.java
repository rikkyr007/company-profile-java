package com.bandingin.rikky.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.rikky.models.Banner;

public interface BannerRepository extends DataTablesRepository<Banner, Integer>{

}
