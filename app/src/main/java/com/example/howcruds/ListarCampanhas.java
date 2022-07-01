package com.example.howcruds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListarCampanhas extends AppCompatActivity {

    private ArrayList<campanha> campArrayList;
    private BDHow dbHandler;
    private campanhaAdapter campanhaAdapter ;
    private RecyclerView campanhaRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_campanhas);

        campArrayList = new ArrayList<>();
        dbHandler = new BDHow(ListarCampanhas.this);

        campArrayList = dbHandler.mostrarCampanha();

        campanhaAdapter = new campanhaAdapter(campArrayList, ListarCampanhas.this);
        campanhaRV = findViewById(R.id.campRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListarCampanhas.this, RecyclerView.VERTICAL, false);
        campanhaRV.setLayoutManager(linearLayoutManager);

        campanhaRV.setAdapter(campanhaAdapter);
    }
}