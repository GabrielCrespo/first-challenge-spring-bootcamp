package com.gabriel.firstchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.firstchallenge.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
