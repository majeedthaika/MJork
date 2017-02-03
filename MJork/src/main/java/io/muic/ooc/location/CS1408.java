package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CS1408 extends Room {
    public CS1408(List<String> possibleCommandList, List<String> connectedRooms, NPC startingCharacter, Map<NPC, Double> characterProbabilities) {
        super("1408", possibleCommandList, connectedRooms, startingCharacter, characterProbabilities);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0: currentMessage = Arrays.asList("The other CS lab.", "You see a 'high'-looking guy named <pj<"); break;
            case 1: currentMessage = Arrays.asList("This lab is much quieter..."); break;
            default: currentMessage = Arrays.asList("This location is weird...");
        }
    }
}
