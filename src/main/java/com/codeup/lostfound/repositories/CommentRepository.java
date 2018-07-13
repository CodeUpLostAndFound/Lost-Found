package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Comment;
import com.sun.tools.javac.jvm.Items;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface CommentRepository extends CrudRepository <Comment, Long>{

        List<Items>findByItemId(int id);

    Comment findByBody(String body);





}
