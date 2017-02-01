package io.muic.ooc;

public class Item {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void use(){

    }

    @Override
    public String toString() {
        return name;
    }
}
