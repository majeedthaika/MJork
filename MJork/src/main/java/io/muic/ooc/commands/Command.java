package io.muic.ooc.commands;

import io.muic.ooc.characters.NPC;

import java.util.List;
import java.util.Set;

public abstract class Command {
    private String mainCommand;
    private Set<String> cmdScenario;

    public Command(String mainWord, Set<String> otherWords){
        try {
            if (!mainWord.isEmpty()) {
                this.mainCommand = mainWord;
                this.cmdScenario = otherWords;
            } else {
                this.mainCommand = "";
                System.out.println("Non-empty command must be given.\n");
            }
        } catch (Exception ex) {
            this.mainCommand = "";
        }
    }

    public String getMainCommand() {
        return mainCommand;
    }

    public abstract void run();

    public NPC isNPCInCommand(Set<NPC> possibleCharacters) {
        for (NPC nextCand : possibleCharacters) {
            if (cmdScenario.contains(nextCand.toString())) {
                return nextCand;
            }
        }
        return null;
    }

    public String isRoomInCommand(List<String> possibleRooms) {
        for (String nextCand : possibleRooms) {
            if (cmdScenario.contains(nextCand.toString())) {
                return nextCand;
            }
        }
        return null;
    }
}
