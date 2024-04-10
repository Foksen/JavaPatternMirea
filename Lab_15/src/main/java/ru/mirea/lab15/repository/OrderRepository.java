package ru.mirea.lab15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab15.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
