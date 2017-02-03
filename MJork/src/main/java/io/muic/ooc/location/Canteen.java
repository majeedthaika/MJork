package io.muic.ooc.location;

import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Canteen extends Room {

    public Canteen(int state, List<String> possibleCommandList, List<String> connectedRooms, Map<NPC, Double> characterProbabilities) {
        super("muic", possibleCommandList, connectedRooms, characterProbabilities, 0);
    }

    public void updateCurrentMessage() {
        switch (getState()) {
            case 0:
                currentMessage = new ArrayList<String>();
                currentMessage.add("You're at the muic lobby");
                if (isCharacterInRoom("bossy")) {
                    currentMessage.add("You see a confused guy named <bossy<.");
                }
                break;
            case 1:
                break;
            default:
                currentMessage = Arrays.asList("This location is weird...");
        }
    }

    public void updateRoom() {
        super.updateRoom();
    }
}
