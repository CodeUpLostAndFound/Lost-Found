package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Category;
import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository <Item, Integer>  {

    List<Item>findByUserId(int id);

    List<Item>findAll();

    Object findOne(int id);

    void delete(int id);

    List<Item> findByZipcodeLike(String zipcode);

    List<Item> findByZipcodeLikeAndAddressLike(String zipcode, String address);

    List<Item> findByUser(User user);

    List<Item> findByCategoriesIn(List<Category> categoryObjects);
//    List<Item> findByComments(List<Comment> commentObjects);










}
