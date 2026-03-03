package com.migudel.staycore.api.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.migudel.staycore.api.users.api.BookingAPI;
import com.migudel.staycore.api.users.models.Client;
import com.migudel.staycore.api.users.models.ClientStatus;
import com.migudel.staycore.api.users.models.UserRol;
import com.migudel.staycore.api.users.repositories.ClientRepository;
import com.migudel.staycore.api.users.utils.Utils;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private BookingAPI bookingAPI;

  @Autowired
  private TokenService tokenService;

  public ResponseEntity<List<Client>> findAll() {
    return ResponseEntity.ok(clientRepository.findAll());
  }

  public ResponseEntity<Client> findById(String token, int id) {
    tokenService.assertPermission(token, id);
    Client client = Utils.assertUser(clientRepository.findById(id));
    return ResponseEntity.ok(client);
  }

  public ResponseEntity<Client> deleteById(String token, int id) {
    tokenService.assertPermission(token, id);
    Client client = Utils.assertUser(clientRepository.findById(id));
    bookingAPI.deleteAllByUserId(id);
    clientRepository.delete(client);
    return ResponseEntity.ok(client);
  }

  public ResponseEntity<Client> save(Client client) {
    // Default rol
    client.setRol(UserRol.CLIENT);
    client = clientRepository.save(client);
    return ResponseEntity.ok(client);
  }

  public ResponseEntity<?> updateClientStatus(int id, ClientStatus status) {
    Client client = Utils.assertUser(clientRepository.findById(id));
    client.setStatus(status);
    client = clientRepository.save(client);
    return ResponseEntity.ok(client);
  }
}
