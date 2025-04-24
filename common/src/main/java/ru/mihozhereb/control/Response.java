package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;

import java.util.List;

/**
 * Response text and a list of {@link MusicBand} objects.
 *
 * @param response
 * @param elements
 */
public record Response(String response, List<MusicBand> elements) {

}
