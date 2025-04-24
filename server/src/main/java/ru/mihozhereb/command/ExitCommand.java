package ru.mihozhereb.command;

import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class ExitCommand implements Command {
    @Override
    public Response execute(Request r) {
        System.exit(0);
        return null;
    }

    @Override
    public String getHelp() {
        return "exit | terminate the program without saving the file";
    }
}
