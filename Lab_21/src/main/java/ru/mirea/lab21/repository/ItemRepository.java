package ru.mirea.lab21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab21.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
