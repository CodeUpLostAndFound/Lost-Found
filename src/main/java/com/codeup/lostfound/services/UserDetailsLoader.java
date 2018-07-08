package com.codeup.lostfound.services;

import com.codeup.lostfound.models.User;
import com.codeup.lostfound.models.UserWithRoles;
import com.codeup.lostfound.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = users.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found!", email));
        }
        return new UserWithRoles(user);
    }
}