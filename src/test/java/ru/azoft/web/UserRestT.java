package ru.azoft.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.azoft.ctrl.UserCtrl;
import ru.azoft.domain.Address;
import ru.azoft.domain.User;
import ru.azoft.repository.AddressRepository;
import ru.azoft.repository.UserRepository;

import java.util.Date;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserCtrl.class)
public class UserRestT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AddressRepository addressRepository;

    private User user;

    private Address address;

    @Before
    public void setup() {
        address = new Address("РФ","г. Новосибирск.","Улица Кутателадзе ","4Г");
        user = new User("Ivan", "Ivanov", "qwerty", "123456", address
                , new Date(), "Хороший");
    }

    @Test
    public void whenRequestGetUsersByRestThenTrue() throws Exception {
        List<User> list = singletonList(user);
        ObjectMapper mapper = new ObjectMapper();
        given(userRepository.findAll()).willReturn(list);
        mvc.perform(get("/users?"))
                .andExpect(status().isOk());

    }

    @Test
    public void whenRequestGetUserByRestByIdThenTrue() throws Exception {
        userRepository.save(user);
        ObjectMapper mapper = new ObjectMapper();
        given(userRepository.findOne(0)).willReturn(user);
        mvc.perform(
                get("/users/0").accept(APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(mapper.writeValueAsString(user))
        );
    }


}