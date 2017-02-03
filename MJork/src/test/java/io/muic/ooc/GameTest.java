package io.muic.ooc;

import io.muic.ooc.commands.CommandWords;
import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testValidCommandWords() throws Exception {
        CommandWords commandWords = new CommandWords(Arrays.asList("help", "go", "enter", "quit"));
        assertTrue(commandWords.isCommand("help"));
        assertFalse(commandWords.isCommand("save"));
        assertTrue(commandWords.isCommand("go"));
    }
}
