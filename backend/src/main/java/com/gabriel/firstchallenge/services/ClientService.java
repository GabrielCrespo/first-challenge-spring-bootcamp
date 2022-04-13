package com.gabriel.firstchallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.firstchallenge.dto.ClientDto;
import com.gabriel.firstchallenge.entities.Client;
import com.gabriel.firstchallenge.repositories.ClientRepository;
import com.gabriel.firstchallenge.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDto> findAllPaged(PageRequest pageRequest) {
		return repository.findAll(pageRequest).map(client -> new ClientDto(client));
	}
	
	@Transactional(readOnly = true)
	public ClientDto findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
		return new ClientDto(client);
	}
	
}
