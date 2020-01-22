package com.bandingin.rikky.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bandingin.rikky.exception.ResourceNotFoundException;
import com.bandingin.rikky.models.Contact;
import com.bandingin.rikky.repositories.ContactRepository;

@Service("contactsService")
public class ContactsService {
	@Autowired
	ContactRepository contactRepository;
	
	public Iterable<Contact> getAll(){
		return contactRepository.findAll();
	}
	
	public DataTablesOutput<Contact> listAll(DataTablesInput input){
		return contactRepository.findAll(input);
	}
	
	public Contact insert(Contact ct) {
		return contactRepository.save(ct);
	}
	
	public Optional<Contact> getById(Integer id){
		return contactRepository.findById(id);
	}
	
	public Contact update(Integer id, Contact contact) {
		Contact ct = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		ct.setFull_name(contact.getFull_name());
		ct.setEmail(contact.getEmail());
		ct.setMessage(contact.getMessage());
		Contact update = contactRepository.save(ct);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		contactRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
