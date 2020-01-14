package com.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.api.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
