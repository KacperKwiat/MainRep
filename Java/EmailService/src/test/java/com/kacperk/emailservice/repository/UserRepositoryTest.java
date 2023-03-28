package com.kacperk.emailservice.repository;

import com.kacperk.emailservice.model.Gender;
import com.kacperk.emailservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        User user=new User();
        user.setPassword("123");
        user.setName("Jasiek");
        user.setSurname("Cosiek");
        user.setEmailName("jascos@email.com");
        user.setGender(Gender.MALE);

        User savedUser=userRepository.save(user);

        User existUser= testEntityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmailName()).isEqualTo(user.getEmailName());

    }

}