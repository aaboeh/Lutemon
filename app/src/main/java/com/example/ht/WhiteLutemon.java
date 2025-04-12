package com.example.ht;

public class WhiteLutemon extends Lutemon{

    public WhiteLutemon(String name) {
        super(name);
        color = "Valkoinen";
        lutemonImage = R.drawable.whitelutemon;
        attack = 5;
        defense = 4;
        maxHealth = 20;
        health = maxHealth;
    }
}
