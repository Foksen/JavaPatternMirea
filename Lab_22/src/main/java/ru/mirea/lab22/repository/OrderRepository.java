package ru.mirea.lab22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.lab22.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
