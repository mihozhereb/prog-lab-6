package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class SaveCommand implements Command {
    @Override
    public Response execute(Request r) {
        CollectionManager.getInstance().save();

        return new Response("Done.", null);
    }

    @Override
    public String getHelp() {
        return "save | save collection in a file";
    }
}
