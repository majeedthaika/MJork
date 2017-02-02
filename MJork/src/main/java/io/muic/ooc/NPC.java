package io.muic.ooc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class NPC {
    String name;
    List<String> image;

    public NPC(String name, String asciiImagePath) {
        this.name = name;
        this.image = loadImageFromPath(asciiImagePath);
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

    public abstract void setCurrentResponse(int option);

    public abstract void talk();

    public abstract int getState();

    public abstract void setState(int state);

        @Override
    public String toString() {
        return name;
    }
}
