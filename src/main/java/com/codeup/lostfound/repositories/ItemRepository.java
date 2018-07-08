package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository <Item, Integer>  {

    List<Item>findAll();



//
//    @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1")
//    List<Item> search(String searchTerm);



}
