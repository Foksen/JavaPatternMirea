package ru.mirea.lab23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab23.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
