package com.example.pokerface.Game;

public class Card {

    private final String symbol;
    private final String type;
    private final int strength;
    private final String name;

    public Card(final String symbol, final String type, final int strength) {
        this.symbol = symbol;
        this.type = type;
        this.strength = strength;
        this.name = symbol + type;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

}
