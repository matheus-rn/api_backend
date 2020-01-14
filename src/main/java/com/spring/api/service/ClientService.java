package com.spring.api.service;

import java.util.List;

import com.spring.api.model.Client;

public interface ClientService {
	List<Client> findAll();
	Client findById(Long id);
	Client save(Client client);
	void delete(Client client);
}
