package com.gerenciadorpedidos.controller;

import com.gerenciadorpedidos.model.Produto;
import com.gerenciadorpedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public Optional<Produto> findByNome(@PathVariable String nome) {
        return produtoService.findByNome(nome);
    }
}
