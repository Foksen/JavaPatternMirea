package ru.mirea.lab17.service;

import ru.mirea.lab17.model.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);
    List<Order> readAll();
    Order read(int id);
    boolean update(Order order, int id);
    boolean delete(int id);
}
