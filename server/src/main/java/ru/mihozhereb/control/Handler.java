package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.command.CommandType;
import ru.mihozhereb.io.ConsoleWorker;
import ru.mihozhereb.io.JsonWorker;

import java.util.Optional;

/**
 * Handler class
 */
public class Handler {
    /**
     * The function processes the string, highlighting the command name, command arguments.
     * If necessary, forms a new object from user input.
     * Creates a {@code Request} object and sends a command for execution, then receives a {@code Response} object
     * from {@code Router} and returns the result of execution in a string form understandable for the user.
     *
     * @param row user command
     * @return result of execution in a string form understandable for the user
     * @see Request
     * @see Response
     * @see Router
     */
    public static String handle(String row, ConsoleWorker cw) {
        String[] args = row.split(" ", 2);

        Optional<MusicBand> element = Optional.empty();

        if (CommandsMap.getCommandType(args[0]) == CommandType.ENTER) {
            InputHelper inputHelper = new InputHelper(cw);
            try {
                element = Optional.ofNullable(inputHelper.input());
            } catch (InputCancelledException e) {
                return e.getLocalizedMessage() + System.lineSeparator();
            }
        }

        Request req = new Request(args[0], args.length == 2 ? args[1] : null, element.orElse(null));
        Response resp = Router.route(req);

        StringBuilder responseText = new StringBuilder(resp.response()).append(System.lineSeparator());

        if (resp.elements() != null) {
            for (MusicBand m : resp.elements()) {
                responseText.append(m.toString()).append(",").append(System.lineSeparator());
            }
        }

        return responseText.toString();
    }
}
