package io.muic.ooc.commands;

import io.muic.ooc.Player;
import io.muic.ooc.characters.NPC;
import io.muic.ooc.location.Room;

import java.util.List;
import java.util.Set;

public class TalkCommand extends Command {
    private Room currentRoom;
    private Player executor;

    public TalkCommand(Set<String> otherWords, Player executor, Room currentRoom) {
        super("talk", otherWords);
        this.currentRoom = currentRoom;
        this.executor = executor;
    }

    @Override
    public void run() {
        Set<NPC> possibleCharacters = currentRoom.getCharacters();
        NPC targetNPC = isNPCInCommand(possibleCharacters);
        if (null != targetNPC) {
            targetNPC.talk();
            currentRoom.removeCharacter(targetNPC);
            executor.increaseSocialExp(targetNPC.getState()*50);
        }
        else System.out.println("No valid character provided.");
    }
}
