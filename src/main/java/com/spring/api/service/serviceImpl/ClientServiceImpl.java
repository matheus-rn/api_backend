package com.spring.api.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.model.Client;
import com.spring.api.repository.ClientRepository;
import com.spring.api.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

}
