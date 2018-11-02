package ru.azoft.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.azoft.domain.Address;
import ru.azoft.domain.User;
import ru.azoft.repository.UserRepository;

import java.util.Date;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSave {

    @Autowired
    private UserRepository userRepository;


    private User user;

    private Address address;

    @Before
    public void setup() {
        address = new Address("РФ","г. Новосибирск.","Улица Кутателадзе ","4Г");
        user = new User("Ivan", "Ivanov", "qwerty", "123456", address
                , new Date(), "Хороший");
    }
    @Test
    public void whenUserInTableThenReturnTrue() {
        userRepository.save(user);
        User userFromDB = userRepository.findOne(user.getId());
        assertTrue(userRepository.exists(user.getId()));
    }

}