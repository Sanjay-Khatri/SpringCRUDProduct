package com.spring;

import com.spring.controller.UserController;
import com.spring.entities.onetomany.MobileEntity;
import com.spring.repositories.MobileRepository;
import com.spring.repositories.PersonRepository;
import com.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MobileRepository mobileRepositoryMock;

    @Autowired
    private UserController userController;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void testGetUser(){
        when(mobileRepositoryMock.save(any())).thenReturn(new MobileEntity());

        userService.getUser("hellol");
    }
}