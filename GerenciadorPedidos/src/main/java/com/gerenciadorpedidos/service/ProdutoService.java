package com.gerenciadorpedidos.service;

import com.gerenciadorpedidos.model.Produto;
import com.gerenciadorpedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Optional<Produto> findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }
}
