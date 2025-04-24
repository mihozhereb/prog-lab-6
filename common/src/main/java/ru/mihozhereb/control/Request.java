package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;

/**
 * Command name, optional argument, and a {@link MusicBand} object.
 *
 * @param command
 * @param argument
 * @param element
 * @see MusicBand
 */
public record Request(String command, String argument, MusicBand element) {
}
