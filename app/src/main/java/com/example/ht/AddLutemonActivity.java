package com.example.ht;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddLutemonActivity extends AppCompatActivity {
    private RadioGroup lutemonTypeRadioGroup;
    private EditText lutemonNameEdit;
    private Button addLutemonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        addLutemonButton = findViewById(R.id.AddLutemonButton);

        addLutemonButton.setOnClickListener(this::addLutemon);
    }

    public void addLutemon(View view) {
        lutemonTypeRadioGroup = findViewById(R.id.LutemonTypeRadioGroup);
        lutemonNameEdit = findViewById(R.id.LutemonNameEdit);

        int selectedId = lutemonTypeRadioGroup.getCheckedRadioButtonId();
        String lutemonName = lutemonNameEdit.getText().toString();

        if (selectedId == -1) {
            ToastHelper.showErrorToast(getApplicationContext(), "Valitse Lutemonin tyyppi!");
            return;
        }

        if (lutemonName.isEmpty()) {
            ToastHelper.showErrorToast(getApplicationContext(), "Anna Lutemonille nimi!");
            return;
        }

        if (lutemonName.length() > 20) {
            ToastHelper.showErrorToast(getApplicationContext(), "Nimi saa olla enintään 20 merkkiä!");
            return;
        }

        if (selectedId == R.id.WhiteLutemonRadioButton) {
            Storage.getInstance().addLutemon(new WhiteLutemon(lutemonName));
        } else if (selectedId == R.id.GreenLutemonRadioButton) {
            Storage.getInstance().addLutemon(new GreenLutemon(lutemonName));
        } else if (selectedId == R.id.PinkLutemonRadioButton) {
            Storage.getInstance().addLutemon(new PinkLutemon(lutemonName));
        } else if (selectedId == R.id.OrangeLutemonRadioButton) {
            Storage.getInstance().addLutemon(new OrangeLutemon(lutemonName));
        } else if (selectedId == R.id.BlackLutemonRadioButton) {
            Storage.getInstance().addLutemon(new BlackLutemon(lutemonName));
        }

        ToastHelper.showSuccessToast(getApplicationContext(), "Lutemon lisätty!");

        lutemonNameEdit.setText("");
        lutemonTypeRadioGroup.clearCheck();
    }
}
