package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.NPC;
import io.muic.ooc.Room;

import java.util.ArrayList;
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
                currentResponse = new ArrayList<String>();
                if (isCharacterInRoom("mom")) {
                    currentResponse.add("Go #talk# to your <mom< before you head out anywhere.");
                }
                currentResponse.add("Type #help# to see possible game commands...");
                break;
            default:
                currentResponse = Arrays.asList("This location is weird...");
        }
    }

    public void printRoomMessage() {
        setRoomMessage(state);
        ConsolePrinter.printWithColor(Arrays.asList("Current Location: <"+getRoomName()+"<"));
        ConsolePrinter.printWithColor(currentResponse);
        if (getState() == 0) setState(1);
    }
}
