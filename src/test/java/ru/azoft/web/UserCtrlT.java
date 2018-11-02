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

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(UserCtrl.class)
public class UserCtrlT {

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
    public void whenUsersGETForwardToAllUsers() throws Exception {
        mvc.perform(get("/users/{id}", user.getId()))
                .andExpect(view().name("edit"));
    }

    @Test
    public void CreateUserSuccess() throws Exception {
        when(userRepository.exists(user.getId())).thenReturn(false);
        ObjectMapper mapper = new ObjectMapper();
        userRepository.save(user);
        mvc.perform(post("/users")
                .contentType(APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(user)))
                .andExpect(status().isOk());
        verify(userRepository, times(2)).save(user);
    }


    @Test
    public void whenDeleteUser() throws Exception {
        when(userRepository.findOne(user.getId())).thenReturn(user);
        doNothing().when(userRepository).delete(user.getId());
        mvc.perform(delete("/users/{id}", user.getId())).andExpect(status().isOk());
        verify(userRepository, times(1)).delete(user.getId());
        verifyNoMoreInteractions(userRepository);
    }


}
