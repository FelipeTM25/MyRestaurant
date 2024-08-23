package com.upb.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.sql.Array;

public class MenuActivity extends ListActivity {
    private String[] categoriasProducto = new String[]{"Entradas","Platos Fuertes","Bebidas","Postres","Licores"};
    private ListView listaCategorias = null;
    private ListAdapter adaptadorLista = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listaCategorias = findViewById(android.R.id.list);

        adaptadorLista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,categoriasProducto);

        listaCategorias.setAdapter(adaptadorLista);
    }

    protected void onListItemClick(ListView lv, View v, int position, long id){

        super.onListItemClick(lv, v, position, id);
        if (position == 0) {
            Intent i;
            i = new Intent(this , ProductoActivity.class);
            startActivity(i);
        }
        if (position == 1) {
            Intent i;
            i = new Intent(this , PlatoFuerteActivity.class);
            startActivity(i);
        }
        if (position == 2) {
            Intent i;
            i = new Intent(this , BebidaActivity.class);
            startActivity(i);
        }
        if (position == 3) {
            Intent i;
            i = new Intent(this , PostreActivity.class);
            startActivity(i);
        }
        if (position == 4) {
            Intent i;
            i = new Intent(this , LicorActivity.class);
            startActivity(i);
        }
    }
}