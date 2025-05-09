package com.example.ht.Fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ht.Lutemon;
import com.example.ht.R;
import com.example.ht.Storage;
import com.example.ht.ToastHelper;

import java.util.ArrayList;


public class MoveFragment extends Fragment {
    private LinearLayout lutemonCheckBoxContainer;
    private RadioGroup lutemonMoveRadioGroup;
    private Button moveLutemonButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_move, container, false);

        lutemonCheckBoxContainer = view.findViewById(R.id.LutemonCheckBoxContainer);
        lutemonMoveRadioGroup = view.findViewById(R.id.LutemonMoveRadioGroup);
        moveLutemonButton = view.findViewById(R.id.MoveLutemonButton);
        boolean lutemonsAdded = false;

        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBox.setTag(lutemon);
            lutemonCheckBoxContainer.addView(checkBox);
            lutemonsAdded = true;
        }

        if (!lutemonsAdded) {
            TextView infoText = new TextView(getContext());
            infoText.setText("Luo uusia Lutemoneja!");
            infoText.setTextColor(Color.BLACK);
            infoText.setTextSize(16);
            lutemonCheckBoxContainer.addView(infoText);
        }

        moveLutemonButton.setOnClickListener(v -> {

            int selectedId = lutemonMoveRadioGroup.getCheckedRadioButtonId();

            ArrayList<Lutemon> selectedLutemons = getSelectedLutemons();
            if (selectedLutemons.size() == 0) {
                ToastHelper.showErrorToast(getContext(), "Valitse vähintään 1 Lutemoni!");
                return;
            }

            if (selectedId == -1) {
                ToastHelper.showErrorToast(getContext(), "Valitse mihin haluat siirtää Lutemonit!");
                return;
            }

            if (selectedId == R.id.HomeRadioButton) {
                for (Lutemon lutemon : selectedLutemons) {
                    moveToHome(lutemon);
                }
            } else if (selectedId == R.id.TrainRadioButton) {
                for (Lutemon lutemon : selectedLutemons) {
                    moveToTrain(lutemon);
                }
            } else if (selectedId == R.id.FightRadioButton) {
                for (Lutemon lutemon : selectedLutemons) {
                    moveToFight(lutemon);
                }
            }

            uncheckAllCheckboxes();
            lutemonMoveRadioGroup.clearCheck();

            ToastHelper.showSuccessToast(getContext(), "Lutemonit siirretty onnistuneesti!");

        });


        return view;
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

    private void moveToHome(Lutemon lutemon) {
        lutemon.setAtHome(true);
        lutemon.setAtTraining(false);
        lutemon.setAtBattle(false);
    }

    private void moveToTrain(Lutemon lutemon) {
        lutemon.setAtTraining(true);
        lutemon.setAtHome(false);
        lutemon.setAtBattle(false);
    }

    private void moveToFight(Lutemon lutemon) {
        lutemon.setAtBattle(true);
        lutemon.setAtHome(false);
        lutemon.setAtTraining(false);
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
