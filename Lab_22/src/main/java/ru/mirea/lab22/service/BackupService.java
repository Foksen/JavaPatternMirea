package ru.mirea.lab22.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mirea.lab22.model.Item;
import ru.mirea.lab22.model.Order;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BackupService {
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;

    private static final Logger log = LoggerFactory.getLogger(BackupService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private void makeItemsBackup() {
        List<Item> items = itemService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup/items.txt", "rw");
            writer.setLength(0);
            for (Item item : items) {
                String itemStr = String.format("%d %s %s %f\n",
                        item.getId(),
                        item.getTitle(),
                        item.getCreationDate(),
                        item.getPrice());
                writer.write(itemStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeOrdersBackup() {
        List<Order> orders = orderService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup/orders.txt\n", "rw");
            writer.setLength(0);
            for (Order order : orders) {
                String orderStr = String.format("%d %s %d\n",
                        order.getId(),
                        order.getOrderDate(),
                        order.getItem().getId());
                writer.write(orderStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* */30 * * * *")
    public void makeBackup() {
        makeItemsBackup();
        makeOrdersBackup();
        log.info("Backups are made: {}", dateFormat.format(new Date()));
    }
}
