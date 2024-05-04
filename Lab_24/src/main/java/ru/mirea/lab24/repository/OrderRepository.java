package ru.mirea.lab24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab24.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
