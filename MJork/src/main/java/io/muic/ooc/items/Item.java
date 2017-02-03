package io.muic.ooc.items;

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public abstract void use();

    public String stringWithDesc() {
        return name+": "+description;
    }

    @Override
    public String toString() {
        return name;
    }
}
