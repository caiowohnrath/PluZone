package com.pluzone.easyfestas.easyfestas.entidade;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ListaResultado {

    private final String MERCADO_CARREFOUR = "Carrefour Dom Pedro";
    private final String MERCADO_EXTRA = "Extra Alphaville";
    private final String MERCADO_PAOACUCAR = "Pão de Açúcar Parque Prado";
    private HashMap<String, Double> precosCarrefour;
    private HashMap<String, Double> precosExtra;
    private HashMap<String, Double> precosPaoAcucar;

    private List<Resultado> listaResultado;

    public ListaResultado () {
        listaResultado = new ArrayList<>();
        precosCarrefour = new HashMap<String, Double>();
        precosExtra = new HashMap<String, Double>();
        precosPaoAcucar = new HashMap<String, Double>();
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
                case MERCADO_CARREFOUR:
                    valores = precosCarrefour;
                    break;
                case MERCADO_EXTRA:
                    valores = precosExtra;
                    break;
                case MERCADO_PAOACUCAR:
                    valores = precosPaoAcucar;
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
        mCarrefour.setNome(MERCADO_CARREFOUR);
        mCarrefour.setDistancia(7);
        mCarrefour.setEndereco("Avenida Mackenzie 1300, Campinas-SP");
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

        // Extra Alphaville
        Mercado mExtra = new Mercado();
        mExtra.setNome(MERCADO_EXTRA);
        mExtra.setDistancia(16);
        mExtra.setEndereco("Rod Dom Pedro km 113, Campinas-SP");
        Resultado rExtra = new Resultado();
        rExtra.setMercado(mExtra);
        listaResultado.add(rExtra);
        precosExtra.put("Picanha Friboi", 38.40);
        precosExtra.put("Picanha Mafrig", 37.90);
        precosExtra.put("Alcatra Friboi", 25.90);
        precosExtra.put("Coca-Cola", 2.55);
        precosExtra.put("Pepsi", 1.99);
        precosExtra.put("Fanta", 2.49);
        precosExtra.put("Itubaína", 1.95);
        precosExtra.put("Skol", 2.59);
        precosExtra.put("Brahma", 2.55);
        precosExtra.put("Heineken", 2.65);
        precosExtra.put("Budweiser", 2.75);
        precosExtra.put("Bom Gelo", 9.09);
        precosExtra.put("Fast Gelo", 8.09);
        precosExtra.put("Planalto", 10.90);
        precosExtra.put("Cacique", 10.50);
        precosExtra.put("Bom de Brasa", 10.15);

        // Pão de Açúcar Parque Prado
        Mercado mPaoAcucar = new Mercado();
        mPaoAcucar.setNome(MERCADO_PAOACUCAR);
        mPaoAcucar.setDistancia(8);
        mPaoAcucar.setEndereco("Avenida XYZ 375, Campinas-SP");
        Resultado rPaoAcucar = new Resultado();
        rPaoAcucar.setMercado(mPaoAcucar);
        listaResultado.add(rPaoAcucar);
        precosPaoAcucar.put("Picanha Friboi", 39.90);
        precosPaoAcucar.put("Picanha Mafrig", 39.49);
        precosPaoAcucar.put("Alcatra Friboi", 25.90);
        precosPaoAcucar.put("Coca-Cola", 2.65);
        precosPaoAcucar.put("Pepsi", 2.15);
        precosPaoAcucar.put("Fanta", 2.59);
        precosPaoAcucar.put("Itubaína", 2.05);
        precosPaoAcucar.put("Skol", 2.57);
        precosPaoAcucar.put("Brahma", 2.52);
        precosPaoAcucar.put("Heineken", 2.75);
        precosPaoAcucar.put("Budweiser", 2.89);
        precosPaoAcucar.put("Bom Gelo", 12.49);
        precosPaoAcucar.put("Fast Gelo", 9.90);
        precosPaoAcucar.put("Planalto", 9.90);
        precosPaoAcucar.put("Cacique", 9.49);
        precosPaoAcucar.put("Bom de Brasa", 8.90);
    }

    public class Resultado implements Comparable<Resultado> {
        Mercado mercado;
        double preco;
        int distancia;

        public int getDistancia() {
            return distancia;
        }

        public void setDistancia(int distancia) {
            this.distancia = distancia;
        }

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

            if (this.distancia < resultado.distancia) {
                return -1;
            }

            if (this.distancia > resultado.distancia) {
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

            s += "\n";
            s += mercado.getEndereco() ;

            s += "\n";
            s += "Distância: " + mercado.getDistancia() + "km";

            return s;
        }
    }

    public List<Resultado> getListaResultado() {
        return listaResultado;
    }
}
