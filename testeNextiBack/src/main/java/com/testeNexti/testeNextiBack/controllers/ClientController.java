package com.testeNexti.testeNextiBack.controllers;

import com.testeNexti.testeNextiBack.models.Client;
import com.testeNexti.testeNextiBack.models.Product;
import com.testeNexti.testeNextiBack.repository.ClientRepository;
import com.testeNexti.testeNextiBack.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/clients"})
public class ClientController {

    private ClientRepository repository;

    ClientController(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Client> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return repository.save(client);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") long id,
                                          @RequestBody Client client){
        return repository.findById(id)
                .map(record -> {
                    record.setName(client.getName());
                    record.setCpf(client.getCpf());
                    record.setBirthDate(client.getBirthDate());

                    Client updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
