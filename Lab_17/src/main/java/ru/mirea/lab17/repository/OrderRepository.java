package ru.mirea.lab17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab17.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
