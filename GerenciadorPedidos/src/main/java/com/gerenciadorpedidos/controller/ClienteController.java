package com.gerenciadorpedidos.controller;

import com.gerenciadorpedidos.model.Cliente;
import com.gerenciadorpedidos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public Optional<Cliente> findByNome(@PathVariable String nome) {
        return clienteService.findByNome(nome);
    }
}
