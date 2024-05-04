package ru.mirea.lab23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab23.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
