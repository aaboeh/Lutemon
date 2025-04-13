package com.example.ht;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button addLutemonActivityButton, listLutemonActivityButton, moveLutemonActivityButton, fightLutemonActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addLutemonActivityButton = findViewById(R.id.AddLutemonActivityButton);
        listLutemonActivityButton = findViewById(R.id.ListLutemonActivityButton);
        moveLutemonActivityButton = findViewById(R.id.MoveLutemonActivityButton);
        fightLutemonActivityButton = findViewById(R.id.FightLutemonActivityButton);

        addLutemonActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddLutemonActivity.class);
            startActivity(intent);
        });

        listLutemonActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListLutemonActivity.class);
            startActivity(intent);
        });

        fightLutemonActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, FightLutemonActivity.class);
            startActivity(intent);
        });

        moveLutemonActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MoveLutemonActivity.class);
            startActivity(intent);
        });
    }
}