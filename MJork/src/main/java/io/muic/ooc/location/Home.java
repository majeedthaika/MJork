package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Home extends Room {

    public Home(List<String> possibleCommandList, List<String> connectedRooms, NPC startingCharacter, Map<NPC, Double> characterProbabilities){
        super("home", possibleCommandList, connectedRooms, startingCharacter, characterProbabilities);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0: currentMessage = Arrays.asList("Go #talk# to your <mom< before you head out anywhere.",
                                                "Type #help# to see possible game commands..."); break;
            case 1: currentMessage = Arrays.asList("You should talk to your <mom< before leaving."); break;
            default: currentMessage = Arrays.asList("This location is weird...");
        }
    }
}
