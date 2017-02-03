package io.muic.ooc;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;
import com.google.common.collect.ImmutableMap;
import io.muic.ooc.characters.*;
import io.muic.ooc.commands.*;
import io.muic.ooc.items.Backpack;
import io.muic.ooc.location.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameInstance {
    public Player player;
    private Parser parser;
    private HashMap<String, Room> allRooms;
    private HashMap<String, NPC> allCharacters;

    public GameInstance() {
        createNPCs();
        buildRooms();
        player = new Player();
        parser = new Parser(player, this);
    }

    public void start() {

        ConsolePrinter.printStartMessage();
        player.setCurrentRoom(getRoomFromName("home"));
        player.getCurrentRoom().printRoomMessage();

        while (true) {
            Command nextCmd = parser.getNextCommand();
            if (null == nextCmd) System.out.println("Command isn't a valid command!!!\n");
            else if (!player.getCurrentRoom().isCommandInRoom(nextCmd)) System.out.println("Command isn't a valid in this location!\n");
            else nextCmd.run();
        }
    }

    public void buildRooms(){
        allRooms = new HashMap<String, Room>();

        allRooms.put("home",
                new Home(Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                         Arrays.asList("muic"),
                         allCharacters.get("mom"),
                         ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("mom"), 1.0)
                                .build()
                ));

        allRooms.put("muic",
                new MUIC(Arrays.asList("help", "info", "look", "go", "talk", "quit"),
                         Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                         allCharacters.get("bossy"),
                         ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.4)
                                .put(allCharacters.get("tow"), 0.1)
                                .put(allCharacters.get("pj"), 0.1)
                                .build()
                ));

        allRooms.put("1408",
                new CS1408(Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                         Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                         allCharacters.get("pj"),
                         ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.0)
                                .put(allCharacters.get("tow"), 0.0)
                                .put(allCharacters.get("pj"), 1.0)
                                .build()
                ));

        allRooms.put("1409",
                new CS1409(Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                         Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                         allCharacters.get("tow"),
                         ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.0)
                                .put(allCharacters.get("tow"), 1.0)
                                .put(allCharacters.get("pj"), 0.0)
                                .build()
                ));

        allRooms.put("canteen",
                new Canteen(Arrays.asList("help", "info", "look", "go", "talk", "quit", "buy"),
                         Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                        null,
                         ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.0)
                                .put(allCharacters.get("tow"), 0.0)
                                .put(allCharacters.get("pj"), 1.0)
                                .build()
                ));

        allRooms.put("lecture",
                new Lecture(Arrays.asList("help", "info", "look", "go", "talk", "quit", "learn", "take"),
                         Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                         null,
                         ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.3)
                                .put(allCharacters.get("tow"), 0.3)
                                .put(allCharacters.get("pj"), 0.2)
                                .build()
                ));
    }

    public Room getRoomFromName(String roomName) {
        return allRooms.get(roomName);
    }

    public HashMap<String, Room> getAllRooms() {
        return allRooms;
    }

    public void createNPCs(){
        allCharacters = new HashMap<String, NPC>();

        allCharacters.put("mom", new Mom());
        allCharacters.put("bossy", new Bossy());
        allCharacters.put("tow", new Tow());
        allCharacters.put("pj", new PJ());
    }
}