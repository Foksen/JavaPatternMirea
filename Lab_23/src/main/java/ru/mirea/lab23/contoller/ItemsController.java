package ru.mirea.lab23.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.lab23.model.Item;
import ru.mirea.lab23.service.ItemServiceImpl;

import java.util.Date;

@Controller
public class ItemsController {
    @Autowired
    private ItemServiceImpl itemService;

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
            return "redirect:/items";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/items/delete_item")
    public String deleteItem(int id) {
        try {
            itemService.delete(id);
            return "redirect:/items";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
