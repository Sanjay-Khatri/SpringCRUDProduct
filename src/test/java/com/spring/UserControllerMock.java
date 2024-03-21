package com.spring;


import com.spring.controller.UserController;
import com.spring.repositories.MobileRepository;
import com.spring.repositories.PersonRepository;
import com.spring.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class UserControllerMock {

//    @InjectMocks
//    private UserController userController;
//
//
//    @Mock
//    private UserService userService;
//
//    @Test
//    public void testGetUser(){
//        when(userService.getUser(anyString())).thenReturn("hello");
//
//        userController.getUser("adf");
//    }

}
