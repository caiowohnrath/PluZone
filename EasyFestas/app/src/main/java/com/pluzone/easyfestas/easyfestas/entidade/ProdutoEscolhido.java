package com.pluzone.easyfestas.easyfestas.entidade;

public class ProdutoEscolhido {

    private String produto;
    private int quantidade;

    public ProdutoEscolhido() {

    }

    public ProdutoEscolhido(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getProduto() {
        return produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String toString() {
        String s = new String();
        s += produto + "\n";
        s += "qtd: " + quantidade;

        return s;
    }
}
