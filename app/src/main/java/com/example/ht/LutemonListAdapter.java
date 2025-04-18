package com.example.ht;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonImage.setImageResource(lutemons.get(position).getLutemonImage());
        holder.lutemonNameText.setText("#" + lutemons.get(position).getId() + " " + lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.lutemonAttackText.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.lutemonDefenseText.setText("Puolustus: " + lutemons.get(position).getDefense());
        holder.lutemonHealthText.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.lutemonExperienceText.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.lutemonStatsText.setText("V: " + lutemons.get(position).getWins() + " H: " + lutemons.get(position).getLosses() + " T: " + lutemons.get(position).getTrainingDays());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
