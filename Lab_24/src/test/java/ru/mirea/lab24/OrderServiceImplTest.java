package ru.mirea.lab24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.lab24.model.Item;
import ru.mirea.lab24.model.Order;
import ru.mirea.lab24.repository.ItemRepository;
import ru.mirea.lab24.repository.OrderRepository;
import ru.mirea.lab24.service.ItemService;
import ru.mirea.lab24.service.ItemServiceImpl;
import ru.mirea.lab24.service.OrderService;
import ru.mirea.lab24.service.OrderServiceImpl;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepository;
    @Captor
    ArgumentCaptor<Order> captor;

    @Test
    void getOrder() {
        Item itemForOrder = new Item();
        itemForOrder.setTitle("Item for order");
        itemForOrder.setCreationDate(new Date());
        itemForOrder.setPrice(10000);

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setItem(itemForOrder);

        Mockito.when(orderRepository.findAll()).thenReturn(List.of(order));
        OrderService orderService = new OrderServiceImpl(orderRepository);
        Assertions.assertEquals(1, orderService.readAll().size());
        Assertions.assertEquals("Item for order", orderService.readAll().get(0).getItem().getTitle());
    }

    @Test
    void saveOrder() {
        Item itemForOrder = new Item();
        itemForOrder.setTitle("Item for order");
        itemForOrder.setCreationDate(new Date());
        itemForOrder.setPrice(10000);

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setItem(itemForOrder);

        OrderService orderService = new OrderServiceImpl(orderRepository);
        orderService.create(order);
        Mockito.verify(orderRepository).save(captor.capture());
        Order captured = captor.getValue();
        Assertions.assertEquals("Item for order", captured.getItem().getTitle());
    }
}
