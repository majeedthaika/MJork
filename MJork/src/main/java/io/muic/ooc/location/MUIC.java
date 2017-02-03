package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MUIC extends Room {
    private int state;
    List<String> currentResponse;

    public MUIC(int state, List<String> possibleCommandList, List<String> connectedRooms, Map<NPC, Double> characterProbabilities) {
        super("muic", possibleCommandList, connectedRooms, characterProbabilities);
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
                currentResponse.add("You're at the muic lobby");
                if (isCharacterInRoom("bossy")) {
                    currentResponse.add("You see a confused guy named <bossy<.");
                }
                break;
            default:
                currentResponse = Arrays.asList("This location is weird...");
                break;

        }
    }

    public void updateRoom() {
        clearCharacters();
        clearItems();
        for (NPC character : getCharacters()) {
            switch (character.getName()) {
                case "bossy":
                    if (character.getState() == 1) setCharacterProbability(character, 0.4);
                    break;
                case "pj":
                    if (character.getState() == 1) setCharacterProbability(character, 0.1);
                    break;
                case "tow":
                    if (character.getState() == 1) setCharacterProbability(character, 0.1);
                    break;
            }
            if (RANDOM.nextDouble() < getCharacterProbability(character)){
                addCharacter(character);
                character.setCurrentRoom(this);
            }
        }
    }

    public void printRoomMessage() {
        setRoomMessage(state);
        ConsolePrinter.printWithColor(Arrays.asList("Current Location: <"+getRoomName()+"<"));
        ConsolePrinter.printWithColor(currentResponse);
        updateRoom();
        if (getState() == 0) setState(1);
    }
}
