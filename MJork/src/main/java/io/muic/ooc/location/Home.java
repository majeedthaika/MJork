package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.NPC;
import io.muic.ooc.Room;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Home extends Room {
    private int state;
    List<String> currentResponse;

    public Home(int state, List<String> possibleCommandList, List<String> connectedRooms, Map<NPC, Double> characterProbabilities) {
        super("home", possibleCommandList, connectedRooms, characterProbabilities);
        setState(state);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        setRoomMessage(state);
    }

    public void setRoomMessage(int option) {
        switch (option) {
            case 0:
                currentResponse = Arrays.asList("Go #talk# to your <mom< before you head out anywhere.",
                        "Type #help# to see possible game commands...");
                break;
            default:
                currentResponse = Arrays.asList("This location is weird...");
        }
    }

    public void printRoomMessage(){
        ConsolePrinter.printWithColor(Arrays.asList("Current Location: <home<"));
        ConsolePrinter.printWithColor(currentResponse);
    }
}
