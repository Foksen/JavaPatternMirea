package ru.mirea.lab16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.lab16.model.Item;
import ru.mirea.lab16.service.ItemServiceImpl;

@Controller
public class ItemsController {
    @Autowired
    private ItemServiceImpl itemService;

    @GetMapping(path = "/items")
    public @ResponseBody ResponseEntity getItems() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(path = "/items")
    public @ResponseBody ResponseEntity createItem(Item item) {
        try {
            itemService.create(item);;
            return ResponseEntity.status(HttpStatus.OK).body("Item was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/items")
    public @ResponseBody ResponseEntity deleteItem(int id) {
        try {
            if (itemService.delete(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Item was deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during deleting");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
