package com.pluzone.easyfestas.easyfestas.entidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rbagni on 15/12/15.
 */
public class ListaResultado {

    private List<Resultado> listaResultado;

    public ListaResultado () {
        listaResultado = new ArrayList<>();
    }

    public void adicionaItemNaLista (Resultado resultado) {
        this.listaResultado.add(resultado);
    }

    public void ordernarPorPreco() {
        Collections.sort(this.listaResultado);
    }

    class Resultado implements Comparable<Resultado> {
        Mercado mercado;
        float preco;

        public int compareTo(Resultado resultado) {
            if (this.preco < resultado.preco) {
                return -1;
            }
            if (this.preco > resultado.preco) {
                return 1;
            }
            return 0;
        }
    }

    public List<Resultado> getListaResultado() {
        return listaResultado;
    }
}
