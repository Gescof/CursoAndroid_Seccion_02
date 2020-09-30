package com.example.seccion_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private GridView gridView;
    private List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView);

        // Datos a mostrar
        nameList = new ArrayList<>();
        nameList.add("Guillermo");
        nameList.add("Carlos");
        nameList.add("Fernando");
        nameList.add("Ann");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked: " + nameList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos con el adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.grid_item, nameList);
        gridView.setAdapter(myAdapter);
    }
}