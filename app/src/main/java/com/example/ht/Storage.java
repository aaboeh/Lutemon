package com.example.ht;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Lutemon> lutemons;
    private static Storage lutemonStorage = null;

    private Storage() {
        lutemons = new ArrayList<>();
    }

    public static Storage getInstance() {
        if (lutemonStorage == null) {
            lutemonStorage = new Storage();
        }
        return lutemonStorage;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }
}
