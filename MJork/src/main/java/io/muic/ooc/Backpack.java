package io.muic.ooc;

import java.util.HashMap;

public class Backpack extends Inventory {
    private int backpackSize;
    private Items items;


    public Backpack(int size){
        this.items = new Items();
        this.backpackSize = size;
    }

    public int getBackpackSize() {
        return backpackSize;
    }

    public void setBackpackSize(int backpackSize) {
        this.backpackSize = backpackSize;
    }

    public void removeItem(String itemName) {
        if (items.remove(itemName)){
            System.out.println("Successfully discarded "+itemName+"!");
        }
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public boolean addItem(Item newItem) {
        if (getNumberOfItems() < backpackSize) {
            items.add(newItem);
            System.out.println("Successfully added "+newItem+"!");
            return true;
        } else {
            System.out.println("Your backpack is full... Please remove item(s) from your backpack first!");
            return false;
        }
    }

    public boolean hasItem(String itemName) {
        return items.contains(itemName);
    }

    public Item getItem(String itemName) {
        if (items.contains(itemName)) return items.get(itemName);
        else {
            System.out.println("You don't have " + itemName + ".");
            return null;
        }
    }

    public void useItem(String itemName) {
        if (items.contains(itemName)) items.get(itemName).use();
        else System.out.println("You do not have a " + itemName + ".");
    }

    public void displayInventory() {
        if (items.size() == 0) {
            System.out.println("Empty inventory.");
        } else {
            String[] allItems = items.getAllItemNames();
            for (int i=0;i<items.size();i++) {
                System.out.println(i+". "+allItems[i]);
            }
        }
    }
}
