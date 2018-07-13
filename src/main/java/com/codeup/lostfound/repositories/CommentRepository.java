package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository <Comment, Long>{

        List<Comment>findByItemId(int id);

    Comment findByBody(String body);





}
