package ru.mirea.lab20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab20.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
