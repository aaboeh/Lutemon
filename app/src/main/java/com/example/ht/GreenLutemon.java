package com.example.ht;

public class GreenLutemon extends Lutemon{

    public GreenLutemon(String name) {
        super(name);
        color = "Vihreä";
        lutemonImage = R.drawable.greenlutemon;
        attack = 6;
        defense = 3;
        maxHealth = 19;
        health = maxHealth;
    }
}
