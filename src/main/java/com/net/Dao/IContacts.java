package com.net.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.net.Model.Contacts;

public interface IContacts extends JpaRepository<Contacts,Integer> {

	public Optional<Contacts> findByName(String name);
}
