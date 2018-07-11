package com.codeup.lostfound.services;

import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.models.User;
import com.codeup.lostfound.repositories.ItemRepository;
import com.codeup.lostfound.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ItemService(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item) {

        // get the user from the session
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.printf("logged in user id: %s, username, %s\n", sessionUser.getId(), sessionUser.getUsername());

        // make sure to get the actual, real deal user from the DB.
        User user = userRepository.findById(sessionUser.getId());

        System.out.println("user: " + user);

        item.setUser(user);
        itemRepository.save(item);
        return item;
    }

    public Item findOne(int id) {
        return (Item) itemRepository.findOne(id);
    }

//    public List<Item> searchByTitle(String title) {
//        return itemRepository.findByTitle(title);
//    }

    public void delete(int id) {
        itemRepository.delete(id);
    }

//    public List<Item> search(String searchTerm) {
//        return itemRepository.search("%" + searchTerm + "%");
//    }
}
