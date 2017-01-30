package io.muic.ooc;

public abstract class Inventory {

    abstract public int getNumberOfItems();

    abstract public boolean addItem(Item newItem);

    abstract public boolean hasItem(String itemName);

    abstract public Item getItem(String newItem);

    abstract public void useItem(String key);

    abstract public void removeItem(String itemName);

    abstract public void displayInventory();
}
