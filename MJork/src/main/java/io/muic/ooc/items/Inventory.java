package io.muic.ooc.items;

import java.util.Collection;

public abstract class Inventory {
    private int maxInventorySize;
    private Items items;

    public Inventory(int size) {
        this.items = new Items();
        this.maxInventorySize = size;
    }

    public int getMaxInventorySize() {
        return maxInventorySize;
    }

    public void setMaxInventorySize(int maxInventorySize) {
        this.maxInventorySize = maxInventorySize;
    }

    public void removeItem(String itemName) {
        if (items.remove(itemName)){
            System.out.println("Successfully discarded "+itemName+"!");
        }
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public Collection<Item> getItems() {
        return items.getItems();
    }

    public boolean addItem(Item newItem) {
        if (getNumberOfItems() < maxInventorySize) {
            items.add(newItem);
//            System.out.println("Successfully added "+newItem+"!");
            return true;
        } else {
//            System.out.println("Your backpack is full... Please remove item(s) from your backpack first!");
            return false;
        }
    }

    public boolean hasItem(String itemName) {
        return items.contains(itemName);
    }

    public Item getItem(String itemName) {
        if (items.contains(itemName)) return items.get(itemName);
        else {
//            System.out.println("You don't have " + itemName + ".");
            return null;
        }
    }

    public void useItem(String itemName) {
        if (items.contains(itemName)) items.get(itemName).use();
//        else System.out.println("You do not have a " + itemName + ".");
    }
}
