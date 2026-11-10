package com.pedido.pedido_service;

public class Pedido {
    private String produto;
    private int quantidade;
    private double total;

    public Pedido(String produto, int quantidade, double total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
