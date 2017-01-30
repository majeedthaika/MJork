package io.muic.ooc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Room {
    private String roomName;
    private List<String> possibleCommandList;
    private List<String> connectedRooms;
    private List<Character> characters;
    private Map<String,Double> characterProbabilities;
    private static final Random RANDOM = new Random();

    public Room(String roomName, List<String> possibleCommandList, List<String> connectedRooms,
                Map<String, Double> characterProbabilities) {
        this.roomName = roomName;
        this.possibleCommandList = possibleCommandList;
        this.connectedRooms = connectedRooms;
        this.characters = new ArrayList<Character>();
        this.characterProbabilities = characterProbabilities;

        new Random()

        for (Map.Entry<String, Double> entry : characterProbabilities.entrySet()) {
            if (RANDOM.nextDouble() < entry.getValue()){
                characters.add(entry.getKey());
            }
        }
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

    public List<Character> getCharacters() {
        return characters;
    }

    public Map<String, Double> getCharacterProbabilities() {
        return characterProbabilities;
    }

    public void setCharacterProbability(String person, Double newProb) {
        this.characterProbabilities.put(person,newProb);
    }

    public String toString() {
        return roomName;
    }
}
