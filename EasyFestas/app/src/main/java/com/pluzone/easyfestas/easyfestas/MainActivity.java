package com.pluzone.easyfestas.easyfestas;

import android.content.Intent;
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
                Intent intent = new Intent(MainActivity.this , ListProductActivity.class);
                intent.putExtra("P1", dropdownBeaf.getSelectedItem().toString());
                intent.putExtra("P1value", Integer.valueOf(editTextBeaf.getText().toString()));

                intent.putExtra("P2", dropdownBeer.getSelectedItem().toString());
                intent.putExtra("P2value", Integer.valueOf(editTextBeer.getText().toString()));

                intent.putExtra("P3", dropdownCoal.getSelectedItem().toString());
                intent.putExtra("P3value", Integer.valueOf(editTextCoal.getText().toString()));

                intent.putExtra("P4", dropdownIce.getSelectedItem().toString());
                intent.putExtra("P4value", Integer.valueOf(editTextIce.getText().toString()));

                intent.putExtra("P5", dropdownSoda.getSelectedItem().toString());
                intent.putExtra("P5value", Integer.valueOf(editTextSoda.getText().toString()));

                startActivity(intent);
            }
        });

    }

    private void createProductPage() {
        dropdownBeaf = (Spinner)findViewById(R.id.beafSpinner);
        String[] itemsBeaf = new String[]{pPicanhaFriboi.getNome(), pPicanhaMafrig.getNome(), pAlcatraFriboi.getNome()};
        ArrayAdapter<String> adapterBeaf = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsBeaf);
        dropdownBeaf.setAdapter(adapterBeaf);
        editTextBeaf = (EditText)findViewById(R.id.editTextBeaf);
        editTextBeaf.setText("0");

        dropdownBeer = (Spinner)findViewById(R.id.beerSpinner);
        String[] itemsBeer = new String[]{pSkol.getNome(), pBrahma.getNome(), pHeineken.getNome(), pBudweiser.getNome()};
        ArrayAdapter<String> adapterBeer = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsBeer);
        dropdownBeer.setAdapter(adapterBeer);
        editTextBeer = (EditText)findViewById(R.id.editTextBeer);
        editTextBeer.setText("0");

        dropdownCoal = (Spinner)findViewById(R.id.coalSpinner);
        String[] itemsCoal = new String[]{pCarvaoBomDeBrasa.getNome(), pCarvaoCaicque.getNome(), pCarvaoPlanalto.getNome()};
        ArrayAdapter<String> adapterCoal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsCoal);
        dropdownCoal.setAdapter(adapterCoal);
        editTextCoal = (EditText)findViewById(R.id.editTextCoal);
        editTextCoal.setText("0");

        dropdownIce = (Spinner)findViewById(R.id.iceSpinner);
        String[] itemsIce = new String[]{pBomGelo.getNome(), pFastGelo.getNome()};
        ArrayAdapter<String> adapterIce = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsIce);
        dropdownIce.setAdapter(adapterIce);
        editTextIce = (EditText)findViewById(R.id.editTextIce);
        editTextIce.setText("0");

        dropdownSoda = (Spinner)findViewById(R.id.sodaSpinner);
        String[] itemsSoda = new String[]{pCocaCola.getNome(), pPepsi.getNome(), pFanta.getNome(), pItubaina.getNome()};
        ArrayAdapter<String> adapterSoda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsSoda);
        dropdownSoda.setAdapter(adapterSoda);
        editTextSoda = (EditText)findViewById(R.id.editTextSoda);
        editTextSoda.setText("0");
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
