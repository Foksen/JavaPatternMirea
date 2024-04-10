package ru.mirea.lab17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab17.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
