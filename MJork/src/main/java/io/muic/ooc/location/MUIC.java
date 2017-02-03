package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MUIC extends Room {
    public MUIC(List<String> possibleCommandList, List<String> connectedRooms, NPC startingCharacter, Map<NPC, Double> characterProbabilities) {
        super("muic", possibleCommandList, connectedRooms, startingCharacter, characterProbabilities);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0: currentMessage = Arrays.asList("You're at the muic lobby",
                                                "You see a confused guy named <bossy<."); break;
            case 1: currentMessage = Arrays.asList("You're at the muic lobby"); break;
            default: currentMessage = Arrays.asList("This location is weird...");
        }
    }
}
