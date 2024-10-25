package com.net.Service;

import java.util.List;

import com.net.Model.Contacts;

public interface IContactService {
	
	public String addNewContact(Contacts contact);
	public List<Contacts> viewAllContacts();
	public String searchContactByName(String name);
	public String partialUpdate(String name,double phoneNumber);
	public String updateContact(Contacts contact);
	public String deleteContact(String name);

}
