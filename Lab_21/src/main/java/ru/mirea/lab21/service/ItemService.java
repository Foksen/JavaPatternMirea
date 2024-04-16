package ru.mirea.lab21.service;


import org.springframework.transaction.annotation.Transactional;
import ru.mirea.lab21.model.Item;

import java.util.List;

public interface ItemService {
    @Transactional
    void create(Item item);

    @Transactional(readOnly = true)
    List<Item> readAll();

    @Transactional(readOnly = true)
    Item read(int id);

    @Transactional
    boolean update(Item item, int id);

    @Transactional
    boolean delete(int id);
}
