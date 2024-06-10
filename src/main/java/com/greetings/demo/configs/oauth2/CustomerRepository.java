package com.greetings.demo.configs.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Boolean existsCustomerByEmail(String email);
    Customer findCustomerByEmail(String emil);

}

