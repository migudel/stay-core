package com.migudel.staycore.api.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.migudel.staycore.api.users.api.HotelApi;
import com.migudel.staycore.api.users.models.Manager;
import com.migudel.staycore.api.users.repositories.ManagerRepository;
import com.migudel.staycore.api.users.utils.Utils;

@Service
public class ManagerService {

  @Autowired
  private HotelApi hotelApi;

  @Autowired
  private ManagerRepository managerRepository;

  @Autowired
  private TokenService tokenService;

  public ResponseEntity<Manager> save(Manager manager) {
    manager = managerRepository.save(manager);
    return ResponseEntity.ok(manager);
  }

  public ResponseEntity<List<Manager>> findAll() {
    List<Manager> managers = managerRepository.findAll();
    return ResponseEntity.ok(managers);
  }

  public ResponseEntity<Manager> findById(String token, int id) {
    tokenService.assertPermission(token, id);
    Manager manager = Utils.assertUser(managerRepository.findById(id));
    return ResponseEntity.ok(manager);
  }

  public ResponseEntity<Manager> deleteById(String token, Integer id) {
    tokenService.assertPermission(token, id);
    Manager manager = Utils.assertUser(managerRepository.findById(id));
    hotelApi.deleteAllByManagerId(id);
    managerRepository.delete(manager);
    return ResponseEntity.ok(manager);
  }
}
