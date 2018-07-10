package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository <Item, Integer>  {

    List<Item>findAll();

    Object findOne(int id);

    void delete(int id);

    List<Item>findByUser(User user);

//    List<Item> search(String s);


//
//    @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1")
//    List<Item> search(String searchTerm);



}
