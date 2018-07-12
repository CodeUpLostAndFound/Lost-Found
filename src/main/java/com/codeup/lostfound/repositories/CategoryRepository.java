package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository <Category, Long>{

//    List<Category> findByCategory(String cat);
    Category findByName(String name);





}
