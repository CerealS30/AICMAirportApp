package com.example.mapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class storesList extends AppCompatActivity {


    private ListView listView;
    private Spinner spinner;
    DBHandler handler;
    ArrayAdapter<stores> adapter;
    String[] categories = {"Todos", "Alimentos y Bebidas", "Compras", "Comunicaciones", "Financieros", "Servicios", "Turisticos"};



    private void setViews(){
        ArrayList<stores> data = getStores();
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories));


        listView = findViewById(R.id.ListView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getStores()));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i >= 0 && i < categories.length){
                    getSelectedCategoryData(i);
                } else {
                    Toast.makeText(storesList.this, "La categoria que seleccionaste no existe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(storesList.this, "El local " + data.get(i).nombre + " se encuentra en " + data.get(i).localizacion, Toast.LENGTH_LONG).show();
            }
        });
    }



    private ArrayList<stores> getStores(){
        Cursor cursor = handler.retrieveStore();
        ArrayList<stores> data = new ArrayList<>();
        data.clear();
        if (cursor.moveToFirst()) {
            do {
                data.add(new stores(cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
               // System.out.println(cursor.getColumnName(3));
            } while (cursor.moveToNext());

        }

        return data;

    }


    private void getSelectedCategoryData(int categoria){
        ArrayList<stores> store = new ArrayList<>();
        if(categoria == 0){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getStores());
        } else {
            for(stores stores : getStores()){
                if(stores.getCategoria() == categoria){
                    store.add(stores);
                }
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, store);
        }

        listView.setAdapter(adapter);
    }


    class stores{

        private String nombre;
        private int categoria;
        private String localizacion;


        public String getNombre(){
            return nombre.toString();
        }

        public String getLocalizacion(){
            return localizacion.toString();
        }

        public int getCategoria(){
            return categoria;
        }


        public stores(String nombre, int categoria, String localizacion){
            this.nombre = nombre;
            this.categoria = categoria;
            this.localizacion = localizacion;
        }

        @Override
        public String toString(){
            return nombre;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_list);
        handler = new DBHandler(this, null, null, 1);
        //addStore();
        setViews();

    }

    public void addStore(){


    }


    public void changeMap(View v){
        Intent intent2 = new Intent(this, MapsActivity.class);
        startActivity(intent2);
    }


}