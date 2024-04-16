package ru.mirea.lab21.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.lab21.model.Item;
import ru.mirea.lab21.service.EmailService;
import ru.mirea.lab21.service.ItemServiceImpl;

import java.util.Date;

@Controller
public class ItemsController {
    @Autowired
    private ItemServiceImpl itemService;
    @Autowired
    private EmailService emailService;

    @GetMapping("items")
    public String getItemsPage(Model model) {
        model.addAttribute("items", itemService.readAll());
        return "items";
    }

    @GetMapping(path = "/items/get_items")
    public @ResponseBody ResponseEntity getItems() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "/items/add_item")
    public String createItem(Item item) {
        try {
            item.setCreationDate(new Date());
            itemService.create(item);;
            emailService.sendSimpleMessage("Item was created [Shop]",
                    String.format("Item (%d [%s]) was created", item.getId(), item.getTitle()));
            return "redirect:/items";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/items/delete_item")
    public String deleteItem(int id) {
        try {
            Item deletedItem = itemService.read(id);
            itemService.delete(id);
            emailService.sendSimpleMessage("Item was deleted [Shop]",
                    String.format("Item (%d [%s]) was deleted", deletedItem.getId(), deletedItem.getTitle()));
            return "redirect:/items";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
