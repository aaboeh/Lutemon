package com.example.ht.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Button;

import com.example.ht.Lutemon;
import com.example.ht.R;
import com.example.ht.Storage;


public class MoveFragment extends Fragment {
    private LinearLayout lutemonCheckBoxContainer;
    private Button moveLutemonButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_move, container, false);

        lutemonCheckBoxContainer = view.findViewById(R.id.LutemonCheckBoxContainer);
        moveLutemonButton = view.findViewById(R.id.MoveLutemonButton);

        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBox.setTag(lutemon);
            lutemonCheckBoxContainer.addView(checkBox);
        }

        moveLutemonButton.setOnClickListener(v -> {

        });

        return view;
    }
}