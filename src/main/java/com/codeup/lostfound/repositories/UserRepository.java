package com.codeup.lostfound.repositories;


import com.codeup.lostfound.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM users LIMIT 1")
    User first();


}




