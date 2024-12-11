package com.gerenciadorpedidos.repository;

import com.gerenciadorpedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByIdsProdutosContaining(Long produtoId);
}
