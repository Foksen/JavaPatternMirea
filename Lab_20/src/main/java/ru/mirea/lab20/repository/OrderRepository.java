package ru.mirea.lab20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab20.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
