package ru.azoft.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.azoft.ctrl.IndexRoutes;
import ru.azoft.repository.AddressRepository;
import ru.azoft.repository.UserRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(IndexRoutes.class)
public class IndexRoutesT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;



    @Test
    public void whenRequestDefaultThenReturnIndex() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/");
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/index.jsp"));
    }


}