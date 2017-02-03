package io.muic.ooc.items;

import java.util.Collection;

public class Backpack extends Inventory {
    public Backpack(int backpackSize) {
        super(backpackSize);
    }

    public void displayInventory() {
        if (getNumberOfItems() == 0) {
            System.out.println("Empty inventory.");
        } else {
            Collection<Item> allItems = getItems();
            for (Item item : allItems) {
                System.out.println(item.stringWithDesc());
            }
        }
    }
}
