package ru.mirea.lab15.service;

import org.springframework.stereotype.Service;
import ru.mirea.lab15.model.Order;
import ru.mirea.lab15.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order read(int id) {
        return orderRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Order order, int id) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            orderRepository.save(order);
            return  true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
