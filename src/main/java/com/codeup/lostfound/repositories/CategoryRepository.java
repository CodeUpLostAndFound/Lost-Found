package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository <Category, Long>{

    List<Category> findByCategory(String cat);




}
