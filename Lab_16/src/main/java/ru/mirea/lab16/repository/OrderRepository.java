package ru.mirea.lab16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab16.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
