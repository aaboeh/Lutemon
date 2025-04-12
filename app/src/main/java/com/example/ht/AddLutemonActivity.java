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
            showErrorToast("Valitse Lutemonin tyyppi!");
            return;
        }

        if (lutemonName.isEmpty()) {
            showErrorToast("Anna Lutemonille nimi!");
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

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,200);
        TextView toastText = new TextView(AddLutemonActivity.this);
        toastText.setTextColor(Color.BLACK);
        toastText.setTextSize(20);
        toastText.setTypeface(toastText.getTypeface(), Typeface.BOLD);
        toastText.setText("Lutemon lisätty!");
        toast.setView(toastText);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        lutemonNameEdit.setText("");
        lutemonTypeRadioGroup.clearCheck();
    }

    public void showErrorToast(String message) {
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,200);
        TextView toastText = new TextView(AddLutemonActivity.this);
        toastText.setTextColor(Color.RED);
        toastText.setTextSize(20);
        toastText.setTypeface(toastText.getTypeface(), Typeface.BOLD);
        toastText.setText(message);
        toast.setView(toastText);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
