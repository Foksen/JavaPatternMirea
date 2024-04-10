package ru.mirea.lab15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.lab15.service.OrderServiceImpl;
import ru.mirea.lab15.model.Order;

@Controller
public class OrdersController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(path = "/orders")
    public @ResponseBody ResponseEntity getOrders() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(path = "/orders")
    public @ResponseBody ResponseEntity createOrder(Order order) {
        try {
            orderService.create(order);;
            return ResponseEntity.status(HttpStatus.OK).body("Order was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/orders")
    public @ResponseBody ResponseEntity deleteOrder(int id) {
        try {
            if (orderService.delete(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Order was deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during deleting");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
