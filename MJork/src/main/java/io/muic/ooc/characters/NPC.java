package io.muic.ooc.characters;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.location.Room;
import io.muic.ooc.items.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class NPC {
    protected String name;
    protected List<String> image;
    protected Room currentRoom;
    protected int state;
    protected List<String> currentResponse;
    protected static final Random RANDOM = new Random();

    public NPC(String name, String asciiImagePath, int state) {
        this.name = name;
        this.image = loadImageFromPath(asciiImagePath);
        this.state = state;
    }

    private List<String> loadImageFromPath(String path) {
        List<String> asciiImage = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = br.readLine()) != null) {
                asciiImage.add(line);
            }
        } catch (Exception ex) {}
        return asciiImage;
    }

    public String getName() {
        return name;
    }

    protected void printImage() {
        for (String imgLine : image){
            System.out.println(imgLine);
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public abstract Item updateCurrentResponse();

    public void talk(){
        printImage();
        Item addToRoom = updateCurrentResponse();
        if (null != addToRoom) currentRoom.addItem(addToRoom);
        ConsolePrinter.printWithColor(currentResponse);
        if (getState() == 0) setState(1);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        updateCurrentResponse();
    }

        @Override
    public String toString() {
        return name;
    }
}
