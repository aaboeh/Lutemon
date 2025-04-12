package com.example.ht;

public class PinkLutemon extends Lutemon{

    public PinkLutemon(String name) {
        super(name);
        color = "Pinkki";
        lutemonImage = R.drawable.pinklutemon;
        attack = 7;
        defense = 2;
        maxHealth = 18;
        health = maxHealth;
    }
}
