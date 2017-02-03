package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lecture extends Room {
    public Lecture(List<String> possibleCommandList, List<String> connectedRooms, NPC startingCharacter, Map<NPC, Double> characterProbabilities) {
        super("lecture", possibleCommandList, connectedRooms, startingCharacter, characterProbabilities);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0: currentMessage = Arrays.asList("You're at the <lecture<."); break;
            case 1: currentMessage = Arrays.asList("Study, study, study..."); break;
            default: currentMessage = Arrays.asList("This location is weird...");
        }
    }
}
