package io.muic.ooc;

import com.google.common.collect.ImmutableMap;
import com.sun.javaws.exceptions.ExitException;
import io.muic.ooc.characters.*;
import io.muic.ooc.commands.QuitCommand;
import io.muic.ooc.items.Car;
import io.muic.ooc.items.MacBook;
import io.muic.ooc.location.CS1408;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class GameTest {

    @Test
    public void testRoomInit() throws Exception {
        GameInstance gameInstance = new GameInstance();

        gameInstance.buildRooms();

        Assert.assertTrue(gameInstance.getAllRooms().get("home").getRoomName() == "home");
        Assert.assertTrue(gameInstance.getAllRooms().get("muic").getRoomName() == "muic");
        Assert.assertTrue(gameInstance.getAllRooms().get("1408").getRoomName() == "1408");
    }

    @Test
    public void testPlayerStats() throws Exception {
        GameInstance gameInstance = new GameInstance();

        Assert.assertTrue(gameInstance.player.getCurrLevel() == 1);
        Assert.assertTrue(gameInstance.player.getEnergyCap() == 7);
        Assert.assertTrue(gameInstance.player.getEnergy() == 7);
        Assert.assertTrue(gameInstance.player.getSocialExp() == 50);
        Assert.assertTrue(gameInstance.player.getStudyExp() == 50);
    }

    @Test
    public void testCar() throws Exception {
        Car car = new Car("car", "desc");
        Assert.assertTrue(car.getName().equals("car"));
    }

    @Test
    public void testMacBook() throws Exception {
        MacBook mac = new MacBook("mac", "desc");
        Assert.assertTrue(mac.getName().equals("mac"));
        mac.setName("book");
        Assert.assertTrue(mac.getName().equals("book"));
    }

    @Test
    public void testCharactersSize() throws Exception {
        Mom mom = new Mom();
        CS1408 cs = new CS1408(Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                mom,
                ImmutableMap.<NPC, Double>builder()
                        .put(mom, 0.0)
                        .build());
        Assert.assertTrue(cs.getCharacters().size() == 1);
    }

    @Test
    public void testCharactersRoomProb() throws Exception {
        Mom mom = new Mom();
        CS1408 cs = new CS1408(Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                mom,
                ImmutableMap.<NPC, Double>builder()
                        .put(mom, 0.0)
                        .build());
        Assert.assertTrue(cs.getCharacterProbability(mom) == 0);
    }

    @Test
    public void testCharacterCurrentRoom() throws Exception {
        Mom mom = new Mom();
        CS1408 cs = new CS1408(Arrays.asList("help", "info", "look", "go", "talk", "quit", "take"),
                Arrays.asList("1408", "1409", "lecture", "canteen", "home"),
                mom,
                ImmutableMap.<NPC, Double>builder()
                        .put(mom, 0.0)
                        .build());
        mom.setCurrentRoom(cs);
        Assert.assertTrue(mom.getCurrentRoom().getRoomName().equals(cs.getRoomName()));
    }

    @Test
    public void testBossyValidResponse() throws Exception {
        Bossy bossy = new Bossy();
        Assert.assertTrue(bossy.getName() == "bossy");
        bossy.setState(0);
        Assert.assertFalse("blah".equals(bossy.getCurrentResponse().get(0)));
        Assert.assertTrue("I understand nothing... Where is Computer Concept's <lecture<???".equals(bossy.getCurrentResponse().get(0)));
        bossy.setState(2);
        Assert.assertFalse("I understand nothing... Where is Computer Concept's <lecture<???".equals(bossy.getCurrentResponse().get(0)));
        Assert.assertTrue("I have nothing to say at this time.".equals(bossy.getCurrentResponse().get(0)));
    }

    @Test
    public void testMomValidResponse() throws Exception {
        Mom mom = new Mom();
        mom.setState(0);
        Assert.assertFalse("blah".equals(mom.getCurrentResponse().get(0)));
        Assert.assertTrue("PJ's Mom: Get ready quick and #go# to <muic<, otherwise you'll be late to your first day of college!".equals(mom.getCurrentResponse().get(0)));
        mom.setState(2);
        Assert.assertFalse("I understand nothing... Where is Computer Concept's <lecture<???".equals(mom.getCurrentResponse().get(0)));
        Assert.assertTrue("I have nothing to say at this time.".equals(mom.getCurrentResponse().get(0)));
    }

    @Test
    public void testPJValidResponse() throws Exception {
        PJ pj = new PJ();
        pj.setState(0);
        Assert.assertFalse("blah".equals(pj.getCurrentResponse().get(0)));
        Assert.assertTrue("Shitttt, I started this HW 2 weeks ago and still need to rely on tokens...".equals(pj.getCurrentResponse().get(0)));
        pj.setState(2);
        Assert.assertFalse("I understand nothing... Where is Computer Concept's <lecture<???".equals(pj.getCurrentResponse().get(0)));
        Assert.assertTrue("I have nothing to say at this time.".equals(pj.getCurrentResponse().get(0)));
    }

    @Test
    public void testTowValidResponse() throws Exception {
        Tow tow = new Tow();
        tow.setState(0);
        Assert.assertFalse("blah".equals(tow.getCurrentResponse().get(0)));
        Assert.assertTrue("You can come to room <1409< a.k.a. CS lab and I can save your life.".equals(tow.getCurrentResponse().get(0)));
        tow.setState(2);
        Assert.assertFalse("I understand nothing... Where is Computer Concept's <lecture<???".equals(tow.getCurrentResponse().get(0)));
        Assert.assertTrue("I have nothing to say at this time.".equals(tow.getCurrentResponse().get(0)));
    }

}
