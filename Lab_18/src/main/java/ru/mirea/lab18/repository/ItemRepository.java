package ru.mirea.lab18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab18.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
