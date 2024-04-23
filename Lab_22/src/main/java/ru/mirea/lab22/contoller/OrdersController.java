package ru.mirea.lab22.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.lab22.service.EmailService;
import ru.mirea.lab22.service.OrderServiceImpl;
import ru.mirea.lab22.model.Order;

import java.util.Date;

@Controller
public class OrdersController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private EmailService emailService;

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
            emailService.sendSimpleMessage("Order was created [Shop]",
                    String.format("Order (%d [%s]) was created", order.getId(), order.getItem().getTitle()));
            return "redirect:/orders";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/orders/delete_order")
    public String deleteOrder(int id) {
        try {
            Order deletedOrder = orderService.read(id);
            orderService.delete(id);
            emailService.sendSimpleMessage("Order was deleted [Shop]",
                    String.format("Order (%d [%s]) was deleted", deletedOrder.getId(), deletedOrder.getItem().getTitle()));
            return "redirect:/orders";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
