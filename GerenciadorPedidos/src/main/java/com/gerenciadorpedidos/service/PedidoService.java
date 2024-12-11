package com.gerenciadorpedidos.service;

import com.gerenciadorpedidos.model.Cliente;
import com.gerenciadorpedidos.model.Pedido;
import com.gerenciadorpedidos.model.Produto;
import com.gerenciadorpedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Pedido save(Pedido pedido) {
        // Validar se cliente e produtos são válidos
        if (pedido.getCliente() == null || pedido.getIdsProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter id de cliente e produtos válidos");
        }

        Optional<Cliente> cliente = clienteService.findById(pedido.getCliente().getId());
        if (cliente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        pedido.getIdsProdutos().forEach(produtoId -> {
            Optional<Produto> produto = produtoService.findById(produtoId);
            if (produto.isEmpty()) {
                throw new IllegalArgumentException("Produto com id " + produtoId + " não encontrado");
            }
        });

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> findByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public List<Pedido> findByProdutoId(Long produtoId) {
        return pedidoRepository.findByIdsProdutosContaining(produtoId);
    }
}
