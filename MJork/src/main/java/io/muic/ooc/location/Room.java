package io.muic.ooc.location;

import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;
import io.muic.ooc.commands.Command;
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
    private NPC startingCharacter;
    protected int state;
    protected List<String> currentMessage;
    protected static final Random RANDOM = new Random();

    public Room(String roomName, List<String> possibleCommandList, List<String> connectedRooms,
                NPC startingCharacter, Map<NPC, Double> characterProbabilities) {
        this.roomName = roomName;
        this.possibleCommandList = possibleCommandList;
        this.connectedRooms = connectedRooms;
        this.characterProbabilities = characterProbabilities;
        this.startingCharacter = startingCharacter;
        this.state = 0;
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

    public boolean isCommandInRoom(Command cmd){
        for (String cand : possibleCommandList) {
            if (cand.equals(cmd.getMainCommand())) return true;
        }
        return false;
    }

    public List<String> getConnectedRooms() {
        return connectedRooms;
    }

    public Set<NPC> getCharacters() {
        return characterProbabilities.keySet();
    }

    public List<NPC> getInRoomCharacters() {
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
            Double prob = null;
            if (character.getState() == 1) {
                prob = getCharacterProbability(character);
            } else if (character.equals(startingCharacter)) {
                prob = 1.0;
            } else{
                prob = 0.0;
            }

            if (RANDOM.nextDouble() < prob){
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
