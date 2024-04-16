package ru.mirea.lab21.service;

import org.springframework.transaction.annotation.Transactional;
import ru.mirea.lab21.model.Order;

import java.util.List;

public interface OrderService {
    @Transactional
    void create(Order order);

    @Transactional(readOnly = true)
    List<Order> readAll();

    @Transactional(readOnly = true)
    Order read(int id);

    @Transactional
    boolean update(Order order, int id);

    @Transactional
    boolean delete(int id);
}
