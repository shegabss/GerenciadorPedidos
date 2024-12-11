package com.gerenciadorpedidos.controller;

import com.gerenciadorpedidos.model.Pedido;
import com.gerenciadorpedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido save(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> findByClienteId(@PathVariable Long clienteId) {
        return pedidoService.findByClienteId(clienteId);
    }

    @GetMapping("/produto/{produtoId}")
    public List<Pedido> findByProdutoId(@PathVariable Long produtoId) {
        return pedidoService.findByProdutoId(produtoId);
    }
}
