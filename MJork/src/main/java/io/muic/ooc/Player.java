package io.muic.ooc;

import java.util.Arrays;

public class Player {
    private int currLevel;
    private int studyExp;
    private int socialExp;
    private int preparedness;
    private int energyCap;
    private int energy;
    private Backpack backpack;

    public Player() {
        this.backpack = null;
        this.currLevel = 1;
        this.studyExp = 50;
        this.socialExp = 50;
        this.preparedness = 0;
        this.energyCap = 2*currLevel + 5;
        this.energy = energyCap;
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }

    public int getStudyExp() {
        return studyExp;
    }

    public void setStudyExp(int studyExp) {
        this.studyExp = studyExp;
    }

    public int getSocialExp() {
        return socialExp;
    }

    public void setSocialExp(int socialExp) {
        this.socialExp = socialExp;
    }

    public int getPreparedness() {
        return preparedness;
    }

    public void setPreparedness(int preparedness) {
        this.preparedness = preparedness;
    }

    public int getEnergyCap() {
        return energyCap;
    }

    public void setEnergyCap(int energyCap) {
        this.energyCap = energyCap;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public void printPlayerInfo() {
        ConsolePrinter.printWithColor(Arrays.asList("Current level: <"+currLevel+"< [current_level = sqrt(study_exp + social_exp)/5 - 1]"));
        ConsolePrinter.printWithColor(Arrays.asList("Current Study exp: <"+studyExp+"< [capped at 2*social_exp]"));
        ConsolePrinter.printWithColor(Arrays.asList("Current Social exp: <"+socialExp+"< [capped at 2*study_exp]"));
        ConsolePrinter.printWithColor(Arrays.asList("How prepared are you for next Exam: <"+preparedness+"</100"));
        ConsolePrinter.printWithColor(Arrays.asList("Current Energy: <"+energy+"</#"+energyCap+"# [max_energy = 2*lvl + 5]",""));
        ConsolePrinter.printWithColor(Arrays.asList("You have the following items in your backpack:"));

        backpack.displayInventory();
    }
}
