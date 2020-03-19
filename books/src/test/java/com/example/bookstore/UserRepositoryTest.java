package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("user");
        
        assertThat(user.getRole()).isEqualTo("USER");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("user2", "password2", "email@email.com", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    

}