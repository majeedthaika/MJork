package io.muic.ooc;

import java.util.HashMap;

public class Items {
    private HashMap<String, Item> items;

    public Items() {
        this.items = new HashMap<String, Item>();
    }

    public int size() {
        return items.size();
    }

    public void add(Item newItem) {
        items.put(newItem.getName(), newItem);
    }

    public Item get(String itemName) {
        return items.get(itemName);
    }

    public boolean remove(String itemName) {
        if (items.containsKey(itemName)) {
            items.remove(itemName);
            return true;
        } else return false;
    }

    public boolean contains(String itemName) {
        return items.containsKey(itemName);
    }

    public String[] getAllItemNames() {
        return (String[]) items.keySet().toArray();
    }
}
