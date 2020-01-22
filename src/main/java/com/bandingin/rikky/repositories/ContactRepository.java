package com.bandingin.rikky.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.rikky.models.Contact;


public interface ContactRepository extends DataTablesRepository<Contact, Integer>{

}
