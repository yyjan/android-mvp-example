package com.example.yun.androidmvpexample.data;

import java.util.ArrayList;
import java.util.Random;

public class DocumentDataRepository {
    private DocumentDataRepository() {

    }

    private static DocumentDataRepository documentDataRepository;

    public static DocumentDataRepository getInstance() {
        if (documentDataRepository == null) {
            documentDataRepository = new DocumentDataRepository();
        }
        return documentDataRepository;
    }

    public ArrayList<Document> getItems(int size) {
        ArrayList<Document> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String title = String.format("Item %d", i + 1);
            items.add(new Document(new Random().nextInt(), title));
        }

        return items;
    }

    public Document newItem(int size) {
        String title = String.format("Item %d", size + 1);
        return new Document(new Random().nextInt(), title);
    }
}
