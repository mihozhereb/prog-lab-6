package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterContainsNameCommand implements Command {
    @Override
    public Response execute(Request r) {
        List<MusicBand> result = new ArrayList<>();

        for (MusicBand i : CollectionManager.getInstance().getCollection()) {
            if (i.getName().contains(r.argument())) {
                result.add(i);
            }
        }

        return new Response("Done.", result);
    }

    @Override
    public String getHelp() {
        return "filter_contains_name name | print items whose name field value contains the specified substring";
    }
}
