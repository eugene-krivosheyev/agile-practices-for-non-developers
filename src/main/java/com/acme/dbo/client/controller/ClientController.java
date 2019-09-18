package com.acme.dbo.client.controller;

import com.acme.dbo.client.dao.ClientRepository;
import com.acme.dbo.client.domain.Client;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PUBLIC;

@ConditionalOnProperty(name = "features.client", havingValue = "true", matchIfMissing = true)
@RestController
@RequestMapping(value = "/api/client", headers = "X-API-VERSION=1")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PUBLIC)
@Slf4j
public class ClientController {
    @Autowired ClientRepository clients;

    @PostMapping
    @ApiOperation(value = "Registration", notes = "Registered new user in service", response = Client.class)
    public ResponseEntity<Client> createClient(@RequestBody @Valid final Client clientDto) {
        return new ResponseEntity<>(
            clients.saveAndFlush(clientDto),
            HttpStatus.CREATED
        );
    }

    @GetMapping
    @ApiOperation(value = "Info", notes = "Get client all clients", response = Collection.class)
    public Collection<Client> getClients() {
        final List<Client> clientsAll = clients.findAll();
        for (Client client : clientsAll) {
            if (!client.getEnabled()) {
                System.out.println(client.getLogin());
            }
        }

        clientsAll.stream()
            .filter(client -> !client.getEnabled())
            .map(client -> client.getId())
            .forEach(id -> System.out.println(id));


        return clientsAll;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Info", notes = "Get client information", response = Client.class)
    public Client getClient(@PathVariable("id") long id) {
        return clients.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
