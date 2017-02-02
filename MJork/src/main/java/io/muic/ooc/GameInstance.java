package io.muic.ooc;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;
import com.google.common.collect.ImmutableMap;
import io.muic.ooc.characters.*;
import io.muic.ooc.commands.*;
import io.muic.ooc.location.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameInstance {
    private Parser parser;
    private Room currentRoom;
    private List<Room> roomHistory;
    private HashMap<String, Room> allRooms;
    private HashMap<String, NPC> allCharacters;
    private Backpack playerItems;

    public Player player;
    public HelpCommand help;

    public GameInstance() {
        player = new Player();
        playerItems = new Backpack(6);
        player.setBackpack(playerItems);
        help = new HelpCommand();
        parser = new Parser();
        createNPCs();
        buildRooms();
    }

    public void start() {
        ColoredPrinter cp = new ColoredPrinter.Builder(1,false).build();

        cp.println("\033\143");
        cp.println("Welcome to MUIC 568 CS Game!!!", Attribute.BOLD, FColor.RED, BColor.WHITE);
        cp.clear();
        cp.println("");
        cp.print("You have woken up from deep sleep...", Attribute.BOLD, FColor.WHITE, BColor.RED);
        cp.clear();
        cp.println("\n");

        setCurrentRoom("home");
        currentRoom.printRoomMessage();

        outerloop:
        while (true) {
            Command nextCmd = parser.getNextCommand();

            if (!nextCmd.isValid()) continue;

            switch (nextCmd.getMainCommand()) {
                case "help":
                    help.setPossibleOptions(currentRoom.getPossibleCommandList(),
                                            currentRoom.getConnectedRooms(),
                                            currentRoom.getCharacters());
                    help.printHelpMessage();
                    break;
                case "look":
                    currentRoom.printRoomMessage();
                    break;
                case "talk":
                    List<NPC> possibleCharacters = currentRoom.getCharacters();
                    NPC targetNPC = nextCmd.isNPCInCommand(possibleCharacters);
                    if (null != targetNPC) {
                        targetNPC.talk();
                        currentRoom.removeCharacter(targetNPC);
                        player.increaseSocialExp(targetNPC.getState()*50);
                    }
                    else cp.println("No valid character provided.");
                    break;
                case "go":
                    List<String> possibleRooms = currentRoom.getConnectedRooms();
                    String targetRoom = nextCmd.isRoomInCommand(possibleRooms);
                    if (null != targetRoom) {
                        setCurrentRoom(targetRoom);
                        currentRoom.printRoomMessage();
                    } else cp.println("Valid location not provided.");
                    break;
                case "info":
                    player.printPlayerInfo();
                    break;
                case "quit":
                    break outerloop;
                default:
                    cp.println("Input isn't a valid command in current situation.\n");
            }
        }
    }

    public void setCurrentRoom(String roomCandidate) {
        currentRoom = allRooms.get(roomCandidate);
        parser.setCommandWords(currentRoom.getPossibleCommandList());
    }

    public void buildRooms(){
        allRooms = new HashMap<String, Room>();

        allRooms.put("home",
                new Home(0,
                        Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                        Arrays.asList("muic"),
                        ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("mom"), 1.0)
                                .build()
                ));

        allRooms.put("muic",
                new MUIC(0,
                        Arrays.asList("help", "info", "look", "go", "talk", "quit"),
                        Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                        ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 1.0)
                                .put(allCharacters.get("tow"), 0.0)
                                .put(allCharacters.get("pj"), 0.0)
                                .build()
                ));

        allRooms.put("1408",
                new MUIC(0,
                        Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                        Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                        ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.0)
                                .put(allCharacters.get("tow"), 1.0)
                                .put(allCharacters.get("pj"), 0.0)
                                .build()
                ));

        allRooms.put("1409",
                new MUIC(0,
                        Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                        Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                        ImmutableMap.<NPC, Double>builder()
                                .put(allCharacters.get("bossy"), 0.0)
                                .put(allCharacters.get("tow"), 0.0)
                                .put(allCharacters.get("pj"), 1.0)
                                .build()
                ));

        allRooms.put("canteen",
                new MUIC(0,
                        Arrays.asList("help", "info", "look", "go", "talk", "quit", "buy"),
                        Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                        ImmutableMap.<NPC, Double>builder()
                                .build()
                ));

        allRooms.put("lecture",
                new MUIC(0,
                        Arrays.asList("help", "info", "look", "go", "talk", "quit", "learn", "take"),
                        Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                        ImmutableMap.<NPC, Double>builder()
                                .build()
                ));
    }

    public void createNPCs(){
        allCharacters = new HashMap<String, NPC>();

        allCharacters.put("mom", new Mom(0));
        allCharacters.put("bossy", new Bossy(0));
        allCharacters.put("tow", new Tow(0));
        allCharacters.put("pj", new PJ(0));
    }
}