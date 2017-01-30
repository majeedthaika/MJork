package io.muic.ooc;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;
import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInstance {
    private Parser parser;
    private Room currentRoom;
    private List<Room> roomHistory;
    private HashMap<String, Room> allRooms;
    private Backpack playerItems;

    public GameInstance() {
        playerItems = new Backpack(6);
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
        cp.println("\n\n");

        cp.print("Go talk to your ");
        cp.print("mom", Attribute.CLEAR, FColor.CYAN, BColor.BLACK);
        cp.println(" before you head out anywhere!");

        cp.print("Type ");
        cp.print("help", Attribute.CLEAR, FColor.YELLOW, BColor.BLACK);
        cp.println(" for help with game commands.");

        cp.clear();

        currentRoom = allRooms.get("Home");
        System.out.println(currentRoom.getCharacterProbabilities());
        parser.getNextCommand();
    }

    public void buildRooms(){
        allRooms = new HashMap<String, Room>();

        allRooms.put("Home",
                new Room("Home",
                        Arrays.asList("help", "talk"),
                        null,
                        ImmutableMap.<String, Double>builder()
                                .put("Mom", 1.0)
                                .build()
                        ));
    }
}