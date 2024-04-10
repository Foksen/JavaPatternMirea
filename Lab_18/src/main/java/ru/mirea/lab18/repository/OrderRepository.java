package ru.mirea.lab18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab18.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
