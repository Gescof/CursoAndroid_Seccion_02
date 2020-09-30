package com.example.seccion_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewMain;
    private List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMain = findViewById(R.id.listViewMain);

        // Datos a mostrar
        nameList = new ArrayList<>();
        nameList.add("Guillermo");
        nameList.add("Carlos");
        nameList.add("Fernando");
        nameList.add("Ann");

        // Adaptador: forma visual en la que se muestran los datos
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);

        // Enlazamos el adaptador con nuestro listView
        // listViewMain.setAdapter(adapter);

        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked: " + nameList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos con el adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, nameList);
        listViewMain.setAdapter(myAdapter);
    }
}