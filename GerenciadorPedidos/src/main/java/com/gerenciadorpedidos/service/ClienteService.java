package com.gerenciadorpedidos.service;

import com.gerenciadorpedidos.model.Cliente;
import com.gerenciadorpedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        if (cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}
