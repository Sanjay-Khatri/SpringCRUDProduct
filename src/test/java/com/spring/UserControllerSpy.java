package com.spring;


import com.spring.entities.onetomany.MobileEntity;
import com.spring.repositories.MobileRepository;
import com.spring.repositories.PersonRepository;
import com.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerSpy {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @MockBean
    private MobileRepository mobileRepository;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void testGetUser() throws Exception {

        when(mobileRepository.save(any())).thenReturn(new MobileEntity());
        when(userService.getUser(any())).thenReturn("hello");
//
        mockMvc.perform(get("/user")
                .param("userId", "1")).andExpect(status().isOk());
//
        verify(mobileRepository, times(1)).save(any());
    }

}
