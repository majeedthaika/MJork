package io.muic.ooc;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Room {
    private String roomName;
    private List<String> possibleCommandList;
    private List<String> connectedRooms;
    private List<NPC> characters;
    private Map<NPC,Double> characterProbabilities;
    private static final Random RANDOM = new Random();

    public Room(String roomName, List<String> possibleCommandList, List<String> connectedRooms,
                Map<NPC, Double> characterProbabilities) {
        this.roomName = roomName;
        this.possibleCommandList = possibleCommandList;
        this.connectedRooms = connectedRooms;
        this.characters = new ArrayList<NPC>();
        this.characterProbabilities = characterProbabilities;

        for (Map.Entry<NPC, Double> entry : characterProbabilities.entrySet()) {
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

    public List<NPC> getCharacters() {
        return characters;
    }

    public Map<NPC, Double> getCharacterProbabilities() {
        return characterProbabilities;
    }

    public void setCharacterProbability(NPC person, Double newProb) {
        this.characterProbabilities.put(person,newProb);
    }

    public abstract void setRoomMessage(int option);

    public abstract void printRoomMessage();

    @Override
    public String toString() {
        return roomName;
    }
}
