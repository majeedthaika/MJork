package io.muic.ooc;

import java.io.BufferedReader;
import java.io.FileReader;

public class NPC {
    String name;
    String hello;
    String asciiImagePath;


    public void printImage() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(asciiImagePath));
//            BufferedReader br = new BufferedReader(new FileReader("src/assets/mom.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
