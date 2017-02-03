package io.muic.ooc;

import io.muic.ooc.items.Backpack;
import io.muic.ooc.location.Room;

import java.util.Arrays;

public class Player {
    private int currLevel;
    private int studyExp;
    private int socialExp;
    private int preparedness;
    private int energyCap;
    private int energy;
    private Room currentRoom;
    private Backpack backpack;

    public Player() {
        this.backpack = new Backpack(6);
        this.studyExp = 50;
        this.socialExp = 50;
        setPreparedness(0);
        calculateLevel();
        calculateEnergyCap();
        refillEnergy();
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void calculateLevel() {
        Double newLvl = Math.floor(Math.sqrt(studyExp + socialExp)/5 - 1);
        this.currLevel = newLvl.intValue();
    }

    public int getStudyExp() {
        return studyExp;
    }

    public void increaseStudyExp(int amount) {
        this.studyExp = Math.min(studyExp+amount,2*socialExp);
    }

    public int getSocialExp() {
        return socialExp;
    }

    public void increaseSocialExp(int amount) {
        this.studyExp = Math.min(socialExp+amount,2*studyExp);
    }

    public int getPreparedness() {
        return preparedness;
    }

    public void setPreparedness(int newValue) {
        this.preparedness = newValue;
    }

    public void increasePreparedness(int amount) {
        this.preparedness = preparedness + amount;
    }

    public int getEnergyCap() {
        return energyCap;
    }

    public void calculateEnergyCap() {
        this.energyCap = (2*currLevel)+5;
    }

    public int getEnergy() {
        return energy;
    }

    public void refillEnergy() {
        this.energy = energyCap;
    }

    public void increaseEnergy(int amount) {
        this.energy = Math.min(energy+amount,energyCap);
    }

    public void decreaseEnergy(int amount) {
        this.energy = Math.max(energy-amount,0);
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public void setCurrentRoom(Room roomCandidate) {
        currentRoom = roomCandidate;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void printPlayerInfo() {
        ConsolePrinter.printWithColor(Arrays.asList("Current level: <"+currLevel+"< [current_level = sqrt(studyExp + socialExp)/5 - 1]"));
        ConsolePrinter.printWithColor(Arrays.asList("Current Study exp: <"+studyExp+"< [capped at 2 * socialExp]"));
        ConsolePrinter.printWithColor(Arrays.asList("Current Social exp: <"+socialExp+"< [capped at 2 * studyExp]"));
        ConsolePrinter.printWithColor(Arrays.asList("How prepared are you for next Exam: <"+preparedness+"< on scale of 10"));
        ConsolePrinter.printWithColor(Arrays.asList("Current Energy: <"+energy+"</#"+energyCap+"# [energyCap = 2 * currLevel + 5]",""));
        ConsolePrinter.printWithColor(Arrays.asList("You have the following items in your backpack:"));

        backpack.displayInventory();
    }
}
