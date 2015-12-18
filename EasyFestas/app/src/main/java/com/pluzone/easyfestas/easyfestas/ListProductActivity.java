package com.pluzone.easyfestas.easyfestas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pluzone.easyfestas.easyfestas.entidade.ListaResultado;
import com.pluzone.easyfestas.easyfestas.entidade.ProdutoEscolhido;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        Intent intent = getIntent();
        String p1 = intent.getStringExtra("P1");
        int valueP1 = intent.getIntExtra("P1value", 0);
        String p2 = intent.getStringExtra("P2");
        int valueP2 = intent.getIntExtra("P2value", 0);
        String p3 = intent.getStringExtra("P3");
        int valueP3 = intent.getIntExtra("P3value", 0);
        String p4 = intent.getStringExtra("P4");
        int valueP4 = intent.getIntExtra("P4value", 0);
        String p5 = intent.getStringExtra("P5");
        int valueP5 = intent.getIntExtra("P5value", 0);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        //TODO chamar o calculo
        ProdutoEscolhido pe1 = new ProdutoEscolhido(p1, valueP1);
        ProdutoEscolhido pe2 = new ProdutoEscolhido(p2, valueP2);
        ProdutoEscolhido pe3 = new ProdutoEscolhido(p3, valueP3);
        ProdutoEscolhido pe4 = new ProdutoEscolhido(p4, valueP4);
        ProdutoEscolhido pe5 = new ProdutoEscolhido(p5, valueP5);

        ArrayList<ProdutoEscolhido> lstProdutoEscolhido = new ArrayList<>();
        lstProdutoEscolhido.add(pe1);
        lstProdutoEscolhido.add(pe2);
        lstProdutoEscolhido.add(pe3);
        lstProdutoEscolhido.add(pe4);
        lstProdutoEscolhido.add(pe5);

        ListaResultado lr = new ListaResultado();
        lr.calculaResultado(lstProdutoEscolhido);
        lr.ordernarPorPreco();
        List<ListaResultado.Resultado> lstResultado = lr.getListaResultado();

        String[] values = new String[lstResultado.size()];
        for(int i= 0; i< lstResultado.size();i++) {
            values[i] = lstResultado.get(i).toString();
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        //TODO qndo clica no item
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // ListView Clicked item index
//                int itemPosition = position;
//                // ListView Clicked item value
//                String itemValue = (String) listView.getItemAtPosition(position);
//                // Show Alert
//                Toast.makeText(getApplicationContext(),
//                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
//                        .show();
//            }
//
//        });
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
    }]

    private void enviarEmail(String[] listaEmail, String assunto, String conteudo) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, listaEmail);
        i.putExtra(Intent.EXTRA_SUBJECT, assunto);
        i.putExtra(Intent.EXTRA_TEXT, conteudo);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ListProductActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
