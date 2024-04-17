package ru.mirea.lab21.service;

import org.springframework.transaction.annotation.Transactional;
import ru.mirea.lab21.model.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);

    List<Order> readAll();

    Order read(int id);

    boolean update(Order order, int id);

    boolean delete(int id);
}
