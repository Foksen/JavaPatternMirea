package ru.mirea.lab21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab21.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
