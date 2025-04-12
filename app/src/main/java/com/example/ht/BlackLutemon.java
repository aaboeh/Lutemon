package com.example.ht;

public class BlackLutemon extends Lutemon {

    public BlackLutemon(String name) {
        super(name);
        color = "Musta";
        lutemonImage = R.drawable.blacklutemon;
        attack = 9;
        defense = 0;
        maxHealth =16;
        health = maxHealth;
    }
}
