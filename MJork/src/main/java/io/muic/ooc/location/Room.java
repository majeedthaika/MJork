package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;
import io.muic.ooc.items.Inventory;
import io.muic.ooc.items.Item;
import io.muic.ooc.items.RoomInventory;

import java.util.*;

public abstract class Room {
    private String roomName;
    private List<String> possibleCommandList;
    private List<String> connectedRooms;
    private List<NPC> characters;
    private Inventory items;
    private Map<NPC,Double> characterProbabilities;
    protected int state;
    protected List<String> currentMessage;
    protected static final Random RANDOM = new Random();

    public Room(String roomName, List<String> possibleCommandList, List<String> connectedRooms,
                Map<NPC, Double> characterProbabilities, int state) {
        this.roomName = roomName;
        this.possibleCommandList = possibleCommandList;
        this.connectedRooms = connectedRooms;
        this.characterProbabilities = characterProbabilities;
        this.state = state;
        updateRoom();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        updateCurrentMessage();
    }

    public String getRoomName() {
        return roomName;
    }

    public List<String> getPossibleCommandList() {
        return possibleCommandList;
    }

    public List<String> getConnectedRooms() {
        return connectedRooms;
    }

    public List<NPC> getCharacters() {
        return characters;
    }

    public void clearCharacters() {
        characters = new ArrayList<NPC>();
    }

    public void clearItems() {
        items = new RoomInventory(3);
    }

    public void addItem(Item target) {
        items.addItem(target);
    }

    public boolean isCharacterInRoom(String name){
        for (NPC nextCand : characters) {
            if (nextCand.getName().equals(name)) return true;
        }
        return false;
    }

    public NPC getCharacter(String name){
        for (NPC nextCand : characters) {
            if (nextCand.getName().equals(name)) return nextCand;
        }
        return null;
    }

    public void addCharacter(NPC target) {
        characters.add(target);
    }

    public void removeCharacter(NPC target) {
        characters.remove(target);
    }

    public Map<NPC, Double> getCharacterProbabilities() {
        return characterProbabilities;
    }

    public void setCharacterProbability(NPC person, Double newProb) {
        this.characterProbabilities.put(person,newProb);
    }

    public double getCharacterProbability(NPC person) {
        return this.characterProbabilities.get(person);
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
                    if (character.getState() == 1) setCharacterProbability(character, 0.2);
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

    public abstract void updateCurrentMessage();

    public void printRoomMessage() {
        updateRoom();
        updateCurrentMessage();
        ConsolePrinter.printWithColor(Arrays.asList("Current Location: <"+getRoomName()+"<"));
        ConsolePrinter.printWithColor(currentMessage);
        if (getState() == 0) setState(1);
    }

    @Override
    public String toString() {
        return roomName;
    }
}
