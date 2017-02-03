package io.muic.ooc.commands;

import io.muic.ooc.Player;

public class QuitCommand extends Command {
    public QuitCommand() {
        super("quit", null);
    }

    @Override
    public void run() {
        System.exit(0);
    }
}
