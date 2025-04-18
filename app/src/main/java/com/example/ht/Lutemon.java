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
    protected boolean atHome;
    protected boolean atBattle;
    protected boolean atTraining;
    public static int idCounter = 0;

    public Lutemon(String name) {
        this.name = name;
        this.experience = 0;
        idCounter ++;
        this.id = idCounter;
        this.atHome = true;
        this.atBattle = false;
        this.atTraining = false;
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

    public boolean isAtHome() {
        return atHome;
    }

    public boolean isAtBattle() {
        return atBattle;
    }

    public boolean isAtTraining() {
        return atTraining;
    }

    public void addExperience(int amount) {
        this.experience += amount;
    }

    public void addAttack(int amount) {
        this.attack += amount;
    }

    public void addDefense(int amount) {
        this.defense += amount;
    }

    public void addMaxHealth(int amount) {
        this.maxHealth += amount;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public void setAtHome(boolean x) {
        this.atHome = x;
    }

    public void setAtBattle(boolean x) {
        this.atBattle = x;
    }

    public void setAtTraining(boolean x) {
        this.atTraining = x;
    }

    public void defense(Lutemon attacker) {
        int damage = attacker.getAttack() - this.getDefense();
        double damageVariance = Math.random();
        if (damageVariance > 0.9) {
            damage += attacker.getExperience();
        } else if (damageVariance < 0.1) {
            damage -= this.getExperience();
            if (damage <= 0) {
                damage = 0;
            }
        }

        this.setHealth(this.getHealth() - damage);

    }
}
