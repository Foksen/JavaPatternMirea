package ru.mirea.Lab14;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {
    @Value("${GITHUB_PAGE}")
    private String GITHUB_PAGE;

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    @GetMapping("/home")
    public @ResponseBody String home() throws IOException {
        WebClient client = WebClient.create(GITHUB_PAGE);
        String responseBody = client.get().retrieve().toEntity(String.class).block().getBody();
        return responseBody;
    }

    @GetMapping("/items")
    public @ResponseBody String returnItems() {
        StringBuilder builder = new StringBuilder();
        for (Item item : items) {
            builder.append(item.getName()).append(" ").append(item.getPrice()).append(" ").append(item.getCreationDate()).append("\n");
        }
        return builder.toString();
    }

    @GetMapping("orders")
    public @ResponseBody String returnOrders() {
        StringBuilder builder = new StringBuilder();
        for (Order order : orders) {
            builder.append(order.getItem().getName()).append(" ")
                            .append(order.getItem().getPrice()).append(" ")
                            .append(order.getItem().getCreationDate()).append(" ")
                            .append(order.getOrderDate()).append("\n");
        }
        return builder.toString();
    }

    @PutMapping("/items/add")
    public @ResponseBody String addItem(@RequestParam String name,
                                        @RequestParam String creationDate,
                                        @RequestParam int price) {
        if (findItem(name) != -1) {
            return "Item with the same name is already exists";
        }
        items.add(new Item(name, creationDate, price));
        return "Success!";
    }

    @PutMapping("/orders/add")
    public @ResponseBody String addOrder(@RequestParam String name,
                                         @RequestParam String creationDate,
                                         @RequestParam int price,
                                         @RequestParam String orderDate) {
        Item item = new Item(name, creationDate, price);
        if (findOrder(item, orderDate) != -1) {
            return "The same order is already exists";
        }
        orders.add(new Order(item, orderDate));
        return "Success!";
    }

    @DeleteMapping(value = "/items/delete")
    public @ResponseBody String removeItem(@RequestParam String name) {
        int id = findItem(name);
        if (id == -1) {
            return "There is no item with that name";
        }
        items.remove(id);
        return "Success";
    }

    @DeleteMapping("/orders/delete")
    public @ResponseBody String removeOrder(@RequestParam String name,
                                         @RequestParam String creationDate,
                                         @RequestParam int price,
                                         @RequestParam String orderDate) {
        Item item = new Item(name, creationDate, price);
        int id = findOrder(item, orderDate);
        if (id == -1) {
            return "The is no such an order";
        }
        orders.remove(id);
        return "Success!";
    }

    private int findItem(String name) {
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    private int findOrder(Item item, String orderDate) {
        for (int i = 0; i < orders.size(); ++i) {
            if (orders.get(i).getItem().equals(item) && orders.get(i).getOrderDate().equals(orderDate))
                return i;
        }
        return -1;
    }
}
