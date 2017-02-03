package io.muic.ooc.commands;

import io.muic.ooc.Player;
import io.muic.ooc.characters.NPC;
import io.muic.ooc.location.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GoCommand extends Command {
    private HashMap<String, Room> allRooms;
    private List<String> possibleRooms;
    private Player executor;

    public GoCommand(Set<String> otherWords, Player executor, List<String> possibleRooms, HashMap<String, Room> allRooms) {
        super("go", otherWords);
        this.allRooms = allRooms;
        this.executor = executor;
        this.possibleRooms = possibleRooms;
    }

    @Override
    public void run() {
        String targetRoom = isRoomInCommand(possibleRooms);
        if (null != targetRoom) {
            executor.setCurrentRoom(allRooms.get(targetRoom));
            executor.getCurrentRoom().printRoomMessage();
        } else System.out.println("Valid location not provided.");
    }
}
