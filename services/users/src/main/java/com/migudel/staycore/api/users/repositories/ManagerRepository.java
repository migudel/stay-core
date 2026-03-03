package com.migudel.staycore.api.users.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.migudel.staycore.api.users.models.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
  Optional<Manager> findByEmail(String email);
}