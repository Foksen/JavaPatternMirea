package ru.mirea.lab19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab19.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
