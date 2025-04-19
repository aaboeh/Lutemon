package com.example.ht.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ht.Lutemon;
import com.example.ht.R;
import com.example.ht.Storage;
import com.example.ht.ToastHelper;

public class HomeFragment extends Fragment {
    private TextView homeLutemonText;
    private Button healLutemonButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeLutemonText = view.findViewById(R.id.HomeLutemonText);
        healLutemonButton = view.findViewById(R.id.HealLutemonButton);
        StringBuilder homeLutemons = new StringBuilder();
        boolean lutemonsAtHome = false;

        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.isAtHome()) {
                homeLutemons.append("#").append(lutemon.getId()).append(" ").append(lutemon.getName()).append(" (").append(lutemon.getColor()).append(")\n");
                lutemonsAtHome = true;
            }
        }

        if (!lutemonsAtHome) {
            homeLutemonText.setText("Lutemoneja ei ole kotona!\nLuo uusia Lutemoneja tai siirrä nykyisiä Lutemoneja kotiin");
        } else {
            homeLutemonText.setText(homeLutemons.toString());
        }

        healLutemonButton.setOnClickListener(v -> {

            boolean atHome = false;

            for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
                if (lutemon.isAtHome()) {
                    lutemon.setHealth(lutemon.getMaxHealth());
                    atHome = true;
                }
            }

            if (!atHome) {
                ToastHelper.showErrorToast(getContext(), "Siirrä Lutemoneja kotiin parannettavaksi!");
            }

            ToastHelper.showSuccessToast(getContext(), "Lutemonit parannettu onnistuneesti!");

        });

        return view;
    }
}