package ru.mirea.lab17.contoller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.lab17.model.Item;
import ru.mirea.lab17.service.ItemServiceImpl;

import java.util.Date;

@Controller
public class ItemsController {
    @Autowired
    private ItemServiceImpl itemService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("items")
    public String getItemsPage(Model model, @RequestParam(required = false) String sort) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item> root = itemCriteriaQuery.from(Item.class);
        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("price")));
        Query<Item> query = (Query<Item>) entityManager.createQuery(itemCriteriaQuery);
        model.addAttribute("items", query.getResultList());
        // model.addAttribute("items", itemService.readAll());
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
