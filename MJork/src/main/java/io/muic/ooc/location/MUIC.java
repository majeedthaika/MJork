package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.NPC;
import io.muic.ooc.Room;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MUIC extends Room {
    private int state;
    List<String> currentResponse;

    public MUIC(int state, List<String> possibleCommandList, List<String> connectedRooms, Map<NPC, Double> characterProbabilities) {
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
                this.currentResponse = Arrays.asList("You are late, but you see another late, clueless student named <bossy<");
                break;
            default:
                this.currentResponse = Arrays.asList("This location is weird...");
        }
        currentResponse.add(0,"Current Location: <muic<");
    }

    public void printRoomMessage(){
        ConsolePrinter.printWithColor(currentResponse);
    }
}
