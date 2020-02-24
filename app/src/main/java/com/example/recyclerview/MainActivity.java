package com.example.recyclerview;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<modelpahlawan> modelPahlawans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvPahlawan);
        recyclerView.setHasFixedSize(true);
        modelPahlawans.addAll(DataPahlawan.getListData());

        showRecyclerList();
    }
    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterPahlawan adapterPahlawan = new AdapterPahlawan(this);
        adapterPahlawan.setModelPahlawans(modelPahlawans);
        recyclerView.setAdapter(adapterPahlawan);
    }
}