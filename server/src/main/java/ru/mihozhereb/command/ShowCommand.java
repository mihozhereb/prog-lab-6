package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

import java.util.ArrayList;

public class ShowCommand implements Command {
    @Override
    public Response execute(Request r) {
        return new Response("Done.", new ArrayList<>(CollectionManager.getInstance().getCollection()));
    }

    @Override
    public String getHelp() {
        return "show | show all elements in collection";
    }
}
