package com.example.fetching;

public class Item {
    private int id;
    private int listId;
    private String name;

    // Getters
    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public void setName(String name) {
        this.name = name;
    }
}