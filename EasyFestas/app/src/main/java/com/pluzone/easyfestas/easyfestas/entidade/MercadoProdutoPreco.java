package com.pluzone.easyfestas.easyfestas.entidade;

public class MercadoProdutoPreco {

    private Produto produto;
    private Mercado mercado;
    private double preco;

    public void MercadoProdutoPreco() {

    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
