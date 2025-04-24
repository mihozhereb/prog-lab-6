package ru.mihozhereb.control;

import ru.mihozhereb.command.*;

/**
 * Router class
 */
public class Router {
    /**
     * Define the command and start execution
     *
     * @param r {@code Request} object
     * @return {@code Response} object
     */
    public static Response route(Request r) {
        if (r.command().equals("help")) {
            return new Response(helpCommand(), null);
        }

        Command command = CommandsMap.getCommand(r.command());

        if (command == null) {
            return new Response("Command not found.", null);
        }

        return command.execute(r);
    }

    /**
     * Collects help information about all commands in the router
     *
     * @return full help text for user
     */
    private static String helpCommand() {
        StringBuilder helpText = new StringBuilder();

        helpText.append("HELP | COMMANDS:").append(System.lineSeparator());

        for (Command i : CommandsMap.getValues()) {
            helpText.append(i.getHelp()).append(System.lineSeparator());
        }

        return helpText.toString();
    }
}
