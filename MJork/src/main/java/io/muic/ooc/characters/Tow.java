package io.muic.ooc.characters;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.NPC;

import java.util.Arrays;
import java.util.List;

public class Tow extends NPC {
    private int state;
    List<String> currentResponse;

    public Tow(int state) {
        super("bossy", "src/assets/bossy");
        setState(state);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        setCurrentResponse(state);
    }

    public void setCurrentResponse(int option) {
        switch (option) {
            case 0:
                this.currentResponse = Arrays.asList("You can come to <room 1409< a.k.a. CS lab and I can save your life.");
                break;
            default:
                this.currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
    }

    public void talk(){
        super.printImage();
        ConsolePrinter.printWithColor(this.currentResponse);
        if (getState() == 0) setState(1);
    }
}
