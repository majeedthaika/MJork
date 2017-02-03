package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CS1409 extends Room {
    public CS1409(List<String> possibleCommandList, List<String> connectedRooms, NPC startingCharacter, Map<NPC, Double> characterProbabilities) {
        super("1409", possibleCommandList, connectedRooms, startingCharacter, characterProbabilities);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0: currentMessage = Arrays.asList("You're at the cs lab <1409<.", "You see a helpful looking guy called <tow<."); break;
            case 1: currentMessage = Arrays.asList("Welcome to <1409< (a.k.a. the nerd lab)."); break;
            default: currentMessage = Arrays.asList("This location is weird...");
        }
    }
}
