package com.example.securityhibernate.services;

import com.example.securityhibernate.models.CustomUserDetail;
import com.example.securityhibernate.models.User;
import com.example.securityhibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findAllByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("Cant not find User name: " + username);
        User user1 = user.get();
        return new CustomUserDetail(user1);
    }
}
