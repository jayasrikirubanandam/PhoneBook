package com.net.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.Model.Contacts;
import com.net.Service.IContactServiceImpl;

@RestController
@RequestMapping("/api")
public class ConController {
	
	@Autowired
	private IContactServiceImpl contactServ;
	
	@PostMapping("/addNewContact")
	public ResponseEntity<String> addContact(@RequestBody Contacts contact){
		
		String s = contactServ.addNewContact(contact);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	@GetMapping("/viewAllContacts")
	public ResponseEntity<List<Contacts>> viewAllContacts(){
		
		return new ResponseEntity<>(contactServ.viewAllContacts(),HttpStatus.OK);
	}
	
	@GetMapping("/searchContact/{name}")
	public ResponseEntity<?> searchContactByName(@PathVariable String name){
		
		String contact = contactServ.searchContactByName(name);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	
	@GetMapping("/partialUpdate/{name}/{phoneNumber}")
	public ResponseEntity<String> partialUpdate(@PathVariable String name, @PathVariable double phoneNumber){
		String status = contactServ.partialUpdate(name, phoneNumber);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@PostMapping("/updateContact")
	public ResponseEntity<String> updateContact(@RequestBody Contacts contact){
		String status = contactServ.updateContact(contact);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteContact/{name}")
	public ResponseEntity<String> deleteContact(@PathVariable String name){
		String status = contactServ.deleteContact(name);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	

}
