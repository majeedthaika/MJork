package io.muic.ooc.commands;

import io.muic.ooc.Player;

import java.util.Set;

public class InfoCommand extends Command {
    private Player executor;

    public InfoCommand(Player executor) {
        super("info", null);
        this.executor = executor;
    }

    @Override
    public void run() {
        executor.printPlayerInfo();
    }
}
