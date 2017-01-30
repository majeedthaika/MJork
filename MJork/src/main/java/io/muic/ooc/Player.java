package io.muic.ooc;

public class Player {
    private String name;
    private int hp;
    private Backpack backpack;

    public Player() {
        this.hp = 0;
        this.backpack = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
}
