package com.pluzone.easyfestas.easyfestas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.pluzone.easyfestas.easyfestas.entidade.Mercado;
import com.pluzone.easyfestas.easyfestas.entidade.MercadoProdutoPreco;
import com.pluzone.easyfestas.easyfestas.entidade.Produto;
import com.pluzone.easyfestas.easyfestas.entidade.ProdutoTipo;

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


        // Defined Array values to show in ListView
        String[] values = new String[] { "Android \nList View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

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
    }
}
