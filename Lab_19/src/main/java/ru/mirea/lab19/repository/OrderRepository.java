package ru.mirea.lab19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab19.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
