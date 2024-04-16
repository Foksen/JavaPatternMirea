package ru.mirea.lab20.service;

import ru.mirea.lab20.model.Item;

import java.util.List;

public interface ItemService {
    void create(Item item);
    List<Item> readAll();
    Item read(int id);
    boolean update(Item item, int id);
    boolean delete(int id);
}
