package ru.mihozhereb;

import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.io.FileWorker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        new FileWorker("test.txt", true);
        new MusicBand();
    }
}