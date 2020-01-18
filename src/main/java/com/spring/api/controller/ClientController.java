package com.spring.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.model.Client;
import com.spring.api.service.ClientService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public List<Client> Get() {
        return clientService.findAll();
    }
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
	public Client Post(@Valid @RequestBody Client client) {
        return clientService.save(client);
    }
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Client client= clientService.findById(id);
        if(client != null){
        	clientService.delete(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/cliente/{id}", method =  RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Client> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Client newClient){
        Client oldClient = clientService.findById(id);
        if(oldClient != null){
            Client client= oldClient;
            client.setNome(newClient.getNome());
            client.setCpf(newClient.getCpf());
            client.setCep(newClient.getCep());
            client.setLogradouro(newClient.getLogradouro());
            client.setBairro(newClient.getBairro());
            client.setCidade(newClient.getCidade());
            client.setUf(newClient.getUf());
            client.setTelefone(newClient.getTelefone());
            client.setEmail(newClient.getEmail());
            clientService.save(client);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
