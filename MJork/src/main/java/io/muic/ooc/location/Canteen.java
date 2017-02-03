package io.muic.ooc.location;

import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Canteen extends Room {
    public Canteen(List<String> possibleCommandList, List<String> connectedRooms, NPC startingCharacter, Map<NPC, Double> characterProbabilities) {
        super("canteen", possibleCommandList, connectedRooms, startingCharacter, characterProbabilities);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0: currentMessage = Arrays.asList("This is where you can buy <chickychic<"); break;
            case 1: currentMessage = Arrays.asList("Have you tried <chickychic< yet?"); break;
            default: currentMessage = Arrays.asList("This location is weird...");
        }
    }
}
