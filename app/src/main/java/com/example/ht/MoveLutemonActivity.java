package com.example.ht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.ht.Fragments.HomeFragment;
import com.example.ht.Fragments.MoveFragment;
import com.example.ht.Fragments.TrainFragment;

public class MoveLutemonActivity extends AppCompatActivity {
    private Button moveViewButton, homeViewButton, trainViewButton, returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemon);



        moveViewButton = findViewById(R.id.MoveViewButton);
        homeViewButton = findViewById(R.id.HomeViewButton);
        trainViewButton = findViewById(R.id.TrainViewButton);
        returnButton = findViewById(R.id.ReturnButton);

        moveViewButton.setOnClickListener(listener);
        homeViewButton.setOnClickListener(listener);
        trainViewButton.setOnClickListener(listener);

        returnButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.LutemonMoveFrame, new MoveFragment())
                .commit();

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            if (view.getId() == R.id.MoveViewButton) {
                fragment = new MoveFragment();
            } else if (view.getId() == R.id.HomeViewButton) {
                fragment = new HomeFragment();
            } else if (view.getId() == R.id.TrainViewButton) {
                fragment = new TrainFragment();
            } else {
                fragment = new MoveFragment();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.LutemonMoveFrame, fragment)
                    .commit();
        }
    };
}
