package com.greetings.demo.configs.oauth2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;

        public CustomUserDetailsService(UserRepository userRepository) {
            this.userRepository = userRepository;

        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            if (userRepository.existsUserByEmail(username)){
                    return new User(username,userRepository.findUserByEmail(username).getPassword(), new ArrayList<>());
            }

            return null;
        }

    }


