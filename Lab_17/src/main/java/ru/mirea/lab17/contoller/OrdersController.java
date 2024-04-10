package ru.mirea.lab17.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.lab17.service.OrderServiceImpl;
import ru.mirea.lab17.model.Order;

import java.util.Date;

@Controller
public class OrdersController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("orders")
    public String getOrdersPage(Model model) {
        model.addAttribute("orders", orderService.readAll());
        return  "orders";
    }

    @GetMapping(path = "/orders/get_orders")
    public @ResponseBody ResponseEntity getOrders() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "/orders/add_order")
    public String createOrder(Order order) {
        try {
            order.setOrderDate(new Date());
            orderService.create(order);
            return "redirect:/orders";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/orders/delete_order")
    public String deleteOrder(int id) {
        try {
            orderService.delete(id);
            return "redirect:/orders";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
