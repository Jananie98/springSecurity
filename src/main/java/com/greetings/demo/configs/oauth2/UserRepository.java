package com.greetings.demo.configs.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByFirstName(String userName);
    User findByFirstName(String userName);
    User findUserByEmail(String userName);
    boolean existsUserByEmail(String email);
    boolean existsUserByMobile(int mobile);
}
