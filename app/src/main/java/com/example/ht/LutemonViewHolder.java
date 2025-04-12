package com.example.ht;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    public ImageView lutemonImage;
    public TextView lutemonNameText, lutemonAttackText, lutemonDefenseText, lutemonHealthText, lutemonExperienceText;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.LutemonImage);
        lutemonNameText = itemView.findViewById(R.id.LutemonNameText);
        lutemonAttackText = itemView.findViewById(R.id.LutemonAttackText);
        lutemonDefenseText = itemView.findViewById(R.id.LutemonDefenseText);
        lutemonHealthText = itemView.findViewById(R.id.LutemonHealthText);
        lutemonExperienceText = itemView.findViewById(R.id.LutemonExperienceText);
    }
}
