package ru.mirea.lab24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mirea.lab24.model.Item;
import ru.mirea.lab24.repository.ItemRepository;
import ru.mirea.lab24.service.ItemService;
import ru.mirea.lab24.service.ItemServiceImpl;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;
    @Captor
    ArgumentCaptor<Item> captor;

    @Test
    void geItems() {
        Item item1 = new Item();
        item1.setTitle("Test item1");
        item1.setCreationDate(new Date());
        item1.setPrice(10000);

        Item item2 = new Item();
        item2.setTitle("Test item2");
        item2.setCreationDate(new Date());
        item2.setPrice(15000);

        Mockito.when(itemRepository.findAll()).thenReturn(List.of(item1, item2));
        ItemService itemService = new ItemServiceImpl(itemRepository);
        Assertions.assertEquals(2, itemService.readAll().size());
        Assertions.assertEquals("Test item2", itemService.readAll().get(1).getTitle());
    }

    @Test
    void saveItem() {
        Item item = new Item();
        item.setTitle("Test item3");
        item.setCreationDate(new Date());
        item.setPrice(5000);
        ItemService itemService = new ItemServiceImpl(itemRepository);
        itemService.create(item);
        Mockito.verify(itemRepository).save(captor.capture());
        Item captured = captor.getValue();
        Assertions.assertEquals("Test item3", captured.getTitle());
    }
}
