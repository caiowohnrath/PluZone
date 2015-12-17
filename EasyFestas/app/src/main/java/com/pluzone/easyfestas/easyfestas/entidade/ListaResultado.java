package com.pluzone.easyfestas.easyfestas.entidade;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ListaResultado {

    private HashMap<String, Double> precosCarrefour;
    //private HashMap<String, Double> precosExtra;

    private List<Resultado> listaResultado;

    public ListaResultado () {
        listaResultado = new ArrayList<>();
        precosCarrefour = new HashMap<String, Double>();
        popularDados();
    }

    public void adicionaItemNaLista (Resultado resultado) {
        this.listaResultado.add(resultado);
    }

    public void ordernarPorPreco() {
        Collections.sort(this.listaResultado);
    }

    public void calculaResultado(ArrayList<ProdutoEscolhido> produtosEscolhidos) {

        for (Resultado r : listaResultado) {
            Mercado m = r.getMercado();

            HashMap<String, Double> valores = null;
            switch (m.getNome()) {
                case "Carrefour Dom Pedro":
                    valores = precosCarrefour;
                    break;
            }

            double valorFinal = 0;

            for (ProdutoEscolhido p : produtosEscolhidos) {
                valorFinal += p.getQuantidade() * valores.get(p.getProduto());
            }

            r.setPreco(valorFinal);
        }
    }

    public void popularDados() {
        Mercado mCarrefour = new Mercado();
        mCarrefour.setNome("Carrefour Dom Pedro");
        Resultado rCarrefour = new Resultado();
        rCarrefour.setMercado(mCarrefour);
        listaResultado.add(rCarrefour);

        // Carrefour Dom Pedro
        precosCarrefour.put("Picanha Friboi", 38.90);
        precosCarrefour.put("Picanha Mafrig", 35.90);
        precosCarrefour.put("Alcatra Friboi", 28.90);
        precosCarrefour.put("Coca-Cola", 2.59);
        precosCarrefour.put("Pepsi", 2.09);
        precosCarrefour.put("Fanta", 2.55);
        precosCarrefour.put("Itubaína", 1.99);
        precosCarrefour.put("Skol", 2.59);
        precosCarrefour.put("Brahma", 2.59);
        precosCarrefour.put("Heineken", 2.69);
        precosCarrefour.put("Budweiser", 2.79);
        precosCarrefour.put("Bom Gelo", 8.99);
        precosCarrefour.put("Fast Gelo", 8.49);
        precosCarrefour.put("Planalto", 12.90);
        precosCarrefour.put("Cacique", 11.90);
        precosCarrefour.put("Bom de Brasa", 10.90);

        /*
        precosExtra.put("Picanha Friboi", 38.90);
        precosExtra.put("Picanha Mafrig", 35.90);
        precosExtra.put("Alcatra Friboi", 28.90);
        precosExtra.put("Coca-Cola", 2.59);
        precosExtra.put("Pepsi", 2.09);
        precosExtra.put("Fanta", 2.55);
        precosExtra.put("Itubaína", 1.99);
        precosExtra.put("Skol", 2.59);
        precosExtra.put("Brahma", 2.59);
        precosExtra.put("Heineken", 2.69);
        precosExtra.put("Budweiser", 2.79);
        precosExtra.put("Bom Gelo", 8.99);
        precosExtra.put("Fast Gelo", 8.49);
        precosExtra.put("Planalto", 12.90);
        precosExtra.put("Cacique", 11.90);
        precosExtra.put("Bom de Brasa", 10.90);


        // Extra Alphaville
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pPicanhaFriboi, 38.40));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pPicanhaMafrig, 37.90));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pAlcatraFriboi, 25.90));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pCocaCola, 2.55));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pPepsi, 1.99));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pFanta, 2.49));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pItubaina, 1.95));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pSkol, 2.59));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pBrahma, 2.55));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pHeineken, 2.65));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pBudweiser, 2.75));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pBomGelo, 9.09));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pFastGelo, 8.09));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pCarvaoPlanalto, 10.90));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pCarvaoCaicque, 10.50));
        listaProdutosDisponiveis.add(criaMMP(mExtraAlphaville, pCarvaoBomDeBrasa, 10.15));

        // Extra Alphaville
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pPicanhaFriboi, 39.90));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pPicanhaMafrig, 39.49));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pAlcatraFriboi, 25.90));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pCocaCola, 2.65));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pPepsi, 2.15));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pFanta, 2.59));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pItubaina, 2.05));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pSkol, 2.57));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pBrahma, 2.52));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pHeineken, 2.75));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pBudweiser, 2.89));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pBomGelo, 12.49));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pFastGelo, 9.90));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pCarvaoPlanalto, 9.90));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pCarvaoCaicque, 9.49));
        listaProdutosDisponiveis.add(criaMMP(mPaoDeAcucarParquePrado, pCarvaoBomDeBrasa, 8.90));
        */
    }
    
    public class Resultado implements Comparable<Resultado> {
        Mercado mercado;
        double preco;

        public Mercado getMercado() {
            return mercado;
        }

        public void setMercado(Mercado mercado) {
            this.mercado = mercado;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public double getPreco() {
            return preco;
        }

        public int compareTo(Resultado resultado) {
            if (this.preco < resultado.preco) {
                return -1;
            }
            if (this.preco > resultado.preco) {
                return 1;
            }
            return 0;
        }

        public String toString() {
            String s = new String();
            s += mercado.getNome() + "\n";
            s += "Total R";

            NumberFormat format = NumberFormat.getCurrencyInstance();
            s += format.format(preco);

            return s;
        }
    }

    public List<Resultado> getListaResultado() {
        return listaResultado;
    }
}
