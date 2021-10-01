package com.rest.template.springbootresttemplateex.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.template.springbootresttemplateex.model.PostUser;
import com.rest.template.springbootresttemplateex.model.User;
import com.rest.template.springbootresttemplateex.service.UserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
public class UserControllerTest {
    @Autowired
    private UserController<Object> userController;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        when(this.userService.addUser((PostUser) any())).thenReturn("foo");

        PostUser postUser = new PostUser();
        postUser.setName("Name");
        postUser.setJob("Job");
        String content = (new ObjectMapper()).writeValueAsString(postUser);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }

    @Test
    public void testGetAllProducts() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<User>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllUsers");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testGetAllProducts2() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<User>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getAllUsers");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

