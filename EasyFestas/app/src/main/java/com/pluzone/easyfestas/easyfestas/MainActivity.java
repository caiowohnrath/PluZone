package com.pluzone.easyfestas.easyfestas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.pluzone.easyfestas.easyfestas.entidade.Mercado;
import com.pluzone.easyfestas.easyfestas.entidade.MercadoProdutoPreco;
import com.pluzone.easyfestas.easyfestas.entidade.Produto;
import com.pluzone.easyfestas.easyfestas.entidade.ProdutoTipo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner dropdownBeaf;
    private Spinner dropdownBeer;
    private Spinner dropdownIce;
    private Spinner dropdownCoal;
    private Spinner dropdownSoda;

    private EditText editTextBeaf;
    private EditText editTextBeer;
    private EditText editTextIce;
    private EditText editTextCoal;
    private EditText editTextSoda;

    private Button nextActivity;

    private ArrayList<MercadoProdutoPreco> listaProdutosDisponiveis = new ArrayList<MercadoProdutoPreco>();

    Produto pPicanhaFriboi;
    Produto pPicanhaMafrig;
    Produto pAlcatraFriboi;

    Produto pCocaCola;
    Produto pPepsi;
    Produto pFanta;
    Produto pItubaina;

    Produto pSkol;
    Produto pBrahma;
    Produto pHeineken;
    Produto pBudweiser;

    Produto pBomGelo;
    Produto pFastGelo;

    Produto pCarvaoPlanalto;
    Produto pCarvaoCaicque;
    Produto pCarvaoBomDeBrasa;

    public void populaDados() {
        // Mercados
        Mercado mCarrefourDomPedro = new Mercado();
        mCarrefourDomPedro.setNome("Carrefour Dom Pedro");

        Mercado mExtraAlphaville = new Mercado();
        mExtraAlphaville.setNome("Extra Alphaville");

        Mercado mPaoDeAcucarParquePrado = new Mercado();
        mPaoDeAcucarParquePrado.setNome("Pão de Açúcar Pq Prado");

        // Produto - Carne
        pPicanhaFriboi = new Produto(ProdutoTipo.carne, "Picanha Friboi", "kg");
        pPicanhaMafrig = new Produto(ProdutoTipo.carne, "Picanha Mafrig", "kg");
        pAlcatraFriboi = new Produto(ProdutoTipo.carne, "Alcatra Friboi", "kg");

        // Produto - Refrigerante
        pCocaCola = new Produto(ProdutoTipo.refrigerante, "Coca-Cola", "lata");
        pPepsi = new Produto(ProdutoTipo.refrigerante, "Pepsi", "lata");
        pFanta = new Produto(ProdutoTipo.refrigerante, "Fanta", "lata");
        pItubaina = new Produto(ProdutoTipo.refrigerante, "Itubaína", "lata");

        // Produto - Cerveja
        pSkol = new Produto(ProdutoTipo.cerveja, "Skol", "lata");
        pBrahma = new Produto(ProdutoTipo.cerveja, "Brahma", "lata");
        pHeineken = new Produto(ProdutoTipo.cerveja, "Heineken", "lata");
        pBudweiser = new Produto(ProdutoTipo.cerveja, "Budweiser", "lata");

        // Produto - Gelo
        pBomGelo = new Produto(ProdutoTipo.gelo, "Bom Gelo", "Pacote 5kg");
        pFastGelo = new Produto(ProdutoTipo.gelo, "Fast Gelo", "Pacote 5kg");

        // Produto - Carvão
        pCarvaoPlanalto = new Produto(ProdutoTipo.carvao, "Planalto", "Pacote 5kg");
        pCarvaoCaicque = new Produto(ProdutoTipo.carvao, "Cacique", "Pacote 5kg");
        pCarvaoBomDeBrasa = new Produto(ProdutoTipo.carvao, "Bom de Brasa", "Pacote 5kg");

        // Carrefour Dom Pedro
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pPicanhaFriboi, 38.90));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pPicanhaMafrig, 35.90));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pAlcatraFriboi, 28.90));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pCocaCola, 2.59));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pPepsi, 2.09));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pFanta, 2.55));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pItubaina, 1.99));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pSkol, 2.59));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pBrahma, 2.59));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pHeineken, 2.69));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pBudweiser, 2.79));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pBomGelo, 8.99));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pFastGelo, 8.49));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pCarvaoPlanalto, 12.90));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pCarvaoCaicque, 11.90));
        listaProdutosDisponiveis.add(criaMMP(mCarrefourDomPedro, pCarvaoBomDeBrasa, 10.90));

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
    }

    public MercadoProdutoPreco criaMMP(Mercado mercado, Produto produto, double preco) {
        MercadoProdutoPreco mmp = new MercadoProdutoPreco();
        mmp.setMercado(mercado);
        mmp.setProduto(produto);
        mmp.setPreco(preco);
        return mmp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.populaDados();
        this.createProductPage();

        final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO implementar a chamada
            }
        });

    }

    private void createProductPage() {
        dropdownBeaf = (Spinner)findViewById(R.id.beafSpinner);
        String[] itemsBeaf = new String[]{pPicanhaFriboi.getNome(), pPicanhaMafrig.getNome(), pAlcatraFriboi.getNome()};
        ArrayAdapter<String> adapterBeaf = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsBeaf);
        dropdownBeaf.setAdapter(adapterBeaf);
        editTextBeaf = (EditText)findViewById(R.id.editTextBeaf);

        dropdownBeer = (Spinner)findViewById(R.id.beerSpinner);
        String[] itemsBeer = new String[]{pSkol.getNome(), pBrahma.getNome(), pHeineken.getNome(), pBudweiser.getNome()};
        ArrayAdapter<String> adapterBeer = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsBeer);
        dropdownBeer.setAdapter(adapterBeer);
        editTextBeer = (EditText)findViewById(R.id.editTextBeer);

        dropdownCoal = (Spinner)findViewById(R.id.coalSpinner);
        String[] itemsCoal = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapterCoal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsCoal);
        dropdownCoal.setAdapter(adapterCoal);
        editTextCoal = (EditText)findViewById(R.id.editTextCoal);

        dropdownIce = (Spinner)findViewById(R.id.iceSpinner);
        String[] itemsIce = new String[]{pBomGelo.getNome(), pFastGelo.getNome()};
        ArrayAdapter<String> adapterIce = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsIce);
        dropdownIce.setAdapter(adapterIce);
        editTextIce = (EditText)findViewById(R.id.editTextIce);

        dropdownSoda = (Spinner)findViewById(R.id.sodaSpinner);
        String[] itemsSoda = new String[]{pCocaCola.getNome(), pPepsi.getNome(), pFanta.getNome(), pItubaina.getNome()};
        ArrayAdapter<String> adapterSoda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsSoda);
        dropdownSoda.setAdapter(adapterSoda);
        editTextSoda = (EditText)findViewById(R.id.editTextSoda);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
