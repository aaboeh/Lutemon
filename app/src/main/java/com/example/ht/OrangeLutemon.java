package com.example.ht;

public class OrangeLutemon extends Lutemon {

    public OrangeLutemon(String name) {
        super(name);
        color = "Oranssi";
        lutemonImage = R.drawable.orangelutemon;
        attack = 8;
        defense = 1;
        maxHealth = 17;
        health = maxHealth;
    }
}
