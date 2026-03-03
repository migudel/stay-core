package com.migudel.staycore.api.users.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.migudel.staycore.api.users.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
  Optional<Client> findByEmail(String email);
}