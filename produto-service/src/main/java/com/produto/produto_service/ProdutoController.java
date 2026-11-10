package com.produto.produto_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final List<Produto> produtos = List.of(
            new Produto(1L, "Teclado", 100.0),
            new Produto(2L, "Mouse", 80.0),
            new Produto(3L, "Monitor", 900.0),
            new Produto(4L, "Headset", 250.0),
            new Produto(5L, "Webcam", 180.0),
            new Produto(6L, "Notebook", 3500.0),
            new Produto(7L, "Cadeira Gamer", 1200.0),
            new Produto(8L, "Mousepad", 30.0),
            new Produto(9L, "Pen Drive", 45.0),
            new Produto(10L, "Impressora", 600.0)
    );

    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar (@PathVariable Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
