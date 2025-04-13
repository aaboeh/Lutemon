package com.example.ht.Fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ht.Lutemon;
import com.example.ht.R;
import com.example.ht.Storage;

import java.util.ArrayList;


public class TrainFragment extends Fragment {
    private LinearLayout trainLutemonCheckBoxContainer;
    private Button trainLutemonButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);

        trainLutemonCheckBoxContainer = view.findViewById(R.id.TrainLutemonCheckBoxContainer);
        trainLutemonButton = view.findViewById(R.id.TrainLutemonButton);
        boolean lutemonsAtTraining = false;

        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.isAtTraining()) {
                CheckBox checkBox = new CheckBox(getContext());
                checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
                checkBox.setTag(lutemon);
                trainLutemonCheckBoxContainer.addView(checkBox);
                lutemonsAtTraining = true;
            }
        }

        if (!lutemonsAtTraining) {
            TextView infoText = new TextView(getContext());
            infoText.setText("Siirrä Lutemoneja treenaamaan!");
            infoText.setTextColor(Color.BLACK);
            infoText.setTextSize(16);
            trainLutemonCheckBoxContainer.addView(infoText);
        }

        trainLutemonButton.setOnClickListener(v -> {

            ArrayList<Lutemon> selectedLutemons = getSelectedLutemons();
            if (selectedLutemons.size() == 0) {
                showErrorToast("Valitse vähintään 1 Lutemoni!");
                return;
            }

            for (Lutemon lutemon : selectedLutemons) {
                lutemon.addExperience(1);
                lutemon.addAttack(1);
                lutemon.addDefense(1);
                lutemon.addMaxHealth(1);
            }

            uncheckAllCheckboxes();

            showSuccessToast("Lutemonit treenasivat onnistuneesti!");

        });

        return view;
    }

    private ArrayList<Lutemon> getSelectedLutemons() {
        ArrayList<Lutemon> selectedLutemons = new ArrayList<>();
        for (int i = 0; i < trainLutemonCheckBoxContainer.getChildCount(); i++) {
            View child = trainLutemonCheckBoxContainer.getChildAt(i);
            if (child instanceof CheckBox && ((CheckBox) child).isChecked()) {
                selectedLutemons.add((Lutemon) child.getTag());
            }
        }
        return selectedLutemons;
    }

    private void showErrorToast(String message) {
        Toast toast = new Toast(getContext());
        toast.setGravity(Gravity.CENTER,0,200);
        TextView toastText = new TextView(getActivity());
        toastText.setTextColor(Color.RED);
        toastText.setTextSize(20);
        toastText.setTypeface(toastText.getTypeface(), Typeface.BOLD);
        toastText.setText(message);
        toast.setView(toastText);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    private void uncheckAllCheckboxes() {
        for (int i = 0; i < trainLutemonCheckBoxContainer.getChildCount(); i++) {
            View child = trainLutemonCheckBoxContainer.getChildAt(i);
            if (child instanceof CheckBox) {
                ((CheckBox) child).setChecked(false);
            }
        }
    }

    private void showSuccessToast(String message) {
        Toast toast = new Toast(getContext());
        toast.setGravity(Gravity.CENTER,0,200);
        TextView toastText = new TextView(getActivity());
        toastText.setTextColor(Color.BLACK);
        toastText.setTextSize(20);
        toastText.setTypeface(toastText.getTypeface(), Typeface.BOLD);
        toastText.setText(message);
        toast.setView(toastText);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
