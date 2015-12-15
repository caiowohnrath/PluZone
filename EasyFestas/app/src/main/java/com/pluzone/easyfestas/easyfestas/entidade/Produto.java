package com.pluzone.easyfestas.easyfestas.entidade;

public class Produto {

    private ProdutoTipo tipo;
    private String nome;
    private String unidadeMedida;

    public void Produto() {

    }

    public void setTipo(ProdutoTipo tipo) {
        this.tipo = tipo;
    }

    public ProdutoTipo getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }
}
