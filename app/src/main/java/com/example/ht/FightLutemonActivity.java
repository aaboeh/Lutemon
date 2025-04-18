package com.example.ht;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.ht.Fragments.FightFragment;

import java.util.ArrayList;

public class FightLutemonActivity extends AppCompatActivity {
    private LinearLayout lutemonCheckBoxContainer;
    private Button fightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_lutemon);

        lutemonCheckBoxContainer = findViewById(R.id.FightLutemonCheckboxContainer);
        fightButton = findViewById(R.id.FightButton);
        boolean lutemonAdded = false;

        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.isAtBattle()) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
                checkBox.setTag(lutemon);
                lutemonCheckBoxContainer.addView(checkBox);
                lutemonAdded = true;
            }
        }

        if (!lutemonAdded) {
            TextView infoText = new TextView(getApplicationContext());
            infoText.setText("Siirrä Lutemoneja taisteluareenalle!");
            infoText.setTextColor(Color.BLACK);
            infoText.setTextSize(16);
            lutemonCheckBoxContainer.addView(infoText);
        }

        fightButton.setOnClickListener(view -> {
            ArrayList<Lutemon> selectedLutemons = getSelectedLutemons();
            if (selectedLutemons.size() != 2) {
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER,0,200);
                TextView toastText = new TextView(FightLutemonActivity.this);
                toastText.setTextColor(Color.RED);
                toastText.setTextSize(20);
                toastText.setTypeface(toastText.getTypeface(), Typeface.BOLD);
                toastText.setText("Valitse 2 Lutemonia taisteluun!");
                toast.setView(toastText);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
                return;
            }

            String fightResult = fight(selectedLutemons.get(0), selectedLutemons.get(1));

            Fragment fightFragment = new FightFragment();
            Bundle data = new Bundle();
            data.putString("dataid", fightResult);
            fightFragment.setArguments(data);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.LutemonFightFrame, fightFragment)
                    .commit();

            uncheckAllCheckboxes();

        });

    }

    private ArrayList<Lutemon> getSelectedLutemons() {
        ArrayList<Lutemon> selectedLutemons = new ArrayList<>();
        for (int i = 0; i < lutemonCheckBoxContainer.getChildCount(); i++) {
            View child = lutemonCheckBoxContainer.getChildAt(i);
            if (child instanceof CheckBox && ((CheckBox) child).isChecked()) {
                selectedLutemons.add((Lutemon) child.getTag());
            }
        }
        return selectedLutemons;
    }

    private String fight(Lutemon lutemon1, Lutemon lutemon2) {
        StringBuilder fightInfo = new StringBuilder();
        Lutemon attacker = lutemon1;
        Lutemon defender = lutemon2;

        while(true) {
            fightInfo.append(getStats(attacker, attacker.getId())).append("\n");
            fightInfo.append(getStats(defender, defender.getId())).append("\n");

            fightInfo.append(attacker.getName()).append("(").append(attacker.getColor()).append(") hyökkää ").append(defender.getName()).append("(").append(defender.getColor()).append(")\n");

            defender.defense(attacker);

            if (defender.getHealth() <= 0) {
                fightInfo.append(defender.getName()).append("(").append(defender.getColor()).append(") kuoli.\n");
                attacker.addExperience(3);
                attacker.addAttack(3);
                attacker.addDefense(3);
                attacker.addMaxHealth(3);
                attacker.wins += 1;
                defender.losses += 1;
                fightInfo.append("Taistelu päättyi!\n");
                break;
            } else {
                fightInfo.append(defender.getName()).append("(").append(defender.getColor()).append(") selvisi hengissä.\n");
            }

            Lutemon temporary = attacker;
            attacker = defender;
            defender = temporary;
        }

        return fightInfo.toString();
    }

    private String getStats(Lutemon lutemon, int number) {
        return number + ": " + lutemon.getName() + "(" + lutemon.getColor() + ") hyökkäys: " + lutemon.getAttack() + "; puolustus: " + lutemon.getDefense() + "; kokemus: " + lutemon.getExperience() + "; elämä: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth();
    }

    private void uncheckAllCheckboxes() {
        for (int i = 0; i < lutemonCheckBoxContainer.getChildCount(); i++) {
            View child = lutemonCheckBoxContainer.getChildAt(i);
            if (child instanceof CheckBox) {
                ((CheckBox) child).setChecked(false);
            }
        }
    }
}
