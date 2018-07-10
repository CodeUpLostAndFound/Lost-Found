package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository <Item, Integer>  {

    List<Item>findAll();

    Object findOne(int id);

    void delete(int id);

    List<Item> findByZipcodeLike(String zipcode);



    @Query(nativeQuery = true, value = "SELECT * FROM item WHERE zipcode LIKE ?1 OR body LIKE ?1")
    List<Item> search(String searchTerm);


}
