package com.example.ht;

public class Lutemon {
    protected String name;
    protected String color;
    protected int lutemonImage;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    public static int idCounter = 0;

    public Lutemon(String name) {
        this.name = name;
        this.experience = 0;
        idCounter ++;
        this.id = idCounter;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public int getLutemonImage() {
        return lutemonImage;
    }

    public void addExperience(int amount) {
        this.experience += amount;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }
}
