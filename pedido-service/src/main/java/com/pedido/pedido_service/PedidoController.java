package com.pedido.pedido_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody PedidoRequest request){
        try{
            Produto produto = restTemplate.getForObject(
                    "http://localhost:8081/produtos/" + request.getProdutoId(), Produto.class
            );

            Pedido pedido = new Pedido(produto.getNome(), request.getQuantidade(), produto.getPreco() * request.getQuantidade());

            return ResponseEntity.ok(pedido);

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body("Serviço não encontrado");

        } catch (ResourceAccessException e) {
            return ResponseEntity.status(503).body("Serviço de produtos indiponível");
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> listarProdutos() {
        try{
            Produto[] produtos = restTemplate.getForObject(
                    "http://localhost:8081/produtos", Produto[].class
            );

            return ResponseEntity.ok(produtos);
        } catch (ResourceAccessException e) {
            return ResponseEntity.status(503).body("Serviço de produtos indisponível");
        }
    }
}
