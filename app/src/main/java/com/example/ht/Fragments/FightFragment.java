package com.example.ht.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ht.R;


public class FightFragment extends Fragment {
    private TextView lutemonFightText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fight, container, false);

        lutemonFightText = view.findViewById(R.id.LutemonFightText);
        if (getArguments() != null) {
            String fightText = getArguments().getString("dataid");
            lutemonFightText.setText(fightText);
        }

        return view;
    }
}