package io.muic.ooc.commands;

import io.muic.ooc.location.Room;

public class LookCommand extends Command{
    private Room currentRoom;

    public LookCommand(Room currentRoom) {
        super("look", null);
        this.currentRoom = currentRoom;
    }

    @Override
    public void run() {
        currentRoom.printRoomMessage();
    }
}
