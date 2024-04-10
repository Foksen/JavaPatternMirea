package ru.mirea.lab16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab16.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
