package com.net.Service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.Dao.IContacts;
import com.net.Exception.ContactNotFound;
import com.net.Model.Contacts;

@Service
public class IContactServiceImpl implements IContactService {

	@Autowired
	private IContacts repo;
	
	@Override
	public String addNewContact(Contacts contact) {
		
		repo.save(contact);
		return "New contact named " +contact.getName() + "has been added";
	}

	@Override
	public List<Contacts> viewAllContacts() {
		return repo.findAll();
		
	}

	@Override
	public String searchContactByName(String name) {
		java.util.Optional<Contacts> optional = repo.findByName(name);
		if(optional.isPresent()) {
			
			Contacts c = repo.findByName(name).get();
			return "Contact has been found " + c;
		}else {
			throw new ContactNotFound("Contact Not found ");
		}
		
	}

	@Override
	public String partialUpdate(String name, double phoneNumber) {
		java.util.Optional<Contacts> optional = repo.findByName(name);
		if(optional.isPresent()) {
			Contacts contact =  optional.get();
			contact.setPhoneNumber(phoneNumber);
			repo.save(contact);
			return "Contact has been updated";
		}else {
			throw new ContactNotFound("Contact Not found ");
		}
	
	}

	@Override
	public String updateContact(Contacts contact ) {
		java.util.Optional<Contacts> optional = repo.findById(contact.getId());
		if(optional.isPresent()) {
			repo.save(contact);
			return "Contact has been updated by name " +contact.getName();
		}else {
			throw new ContactNotFound("Contact Not found ");
		}
		
	}

	@Override
	public String deleteContact(String name) {
		
		java.util.Optional<Contacts> optional = repo.findByName(name);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Contact has been deleted";
		}else {
			throw new ContactNotFound("Contact Not found ");
		}
	}

	

	
	

}
