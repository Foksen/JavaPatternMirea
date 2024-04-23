package ru.mirea.lab22.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.lab22.model.Item;
import ru.mirea.lab22.repository.ItemRepository;

import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    @Transactional
    public void create(Item item) {
        log.info("Create item");
        itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> readAll() {
        log.info("Read all items");
        return itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Item read(int id) {
        log.info("Read item " + id);
        return itemRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public boolean update(Item item, int id) {
        log.info("Update item " + id);
        if (itemRepository.existsById(id)) {
            item.setId(id);
            itemRepository.save(item);
            return  true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        log.info("Delete item " + id);
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
