package com.example.ht;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListLutemonActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;
    private TextView listInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemon);

        listInfoText = findViewById(R.id.ListInfoText);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.ListLutemonRV);

        if (storage.getLutemons().isEmpty()) {
            listInfoText.setText("Lisää uusia lutemoneja, jotta niitä voidaan listata!");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getLutemons()));
    }
}