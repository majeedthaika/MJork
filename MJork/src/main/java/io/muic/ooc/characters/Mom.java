package io.muic.ooc.characters;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.NPC;

import java.util.Arrays;
import java.util.List;

public class Mom extends NPC {
    private int state;
    List<String> currentResponse;

    public Mom(int state) {
        super("mom", "src/assets/mom");
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
                this.currentResponse = Arrays.asList("PJ's Mom: Get ready quick and #go# to <muic<, otherwise you'll be late to your first day of college!");
                break;
            default:
                this.currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
    }

    public void talk(){
        super.printImage();
        ConsolePrinter.printWithColor(this.currentResponse);
    }
}
