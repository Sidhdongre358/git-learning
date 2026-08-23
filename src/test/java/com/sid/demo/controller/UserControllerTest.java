package com.sid.demo.controller;

import com.sid.demo.model.User;
import org.junit.jupiter.api.Test;

import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @Test
    public void getUsers_returnsAll() {
        UserController controller = new UserController();
        List<User> users = controller.getUsers();
        assertEquals(6, users.size());
    }

    @Test
    public void getUserById_returnsUser() {
        UserController controller = new UserController();
        ResponseEntity<User> resp = controller.getUserById(4L);
        assertEquals(200, resp.getStatusCode().value());
        assertNotNull(resp.getBody());
        assertEquals("Diana Prince", resp.getBody().getName());
    }
}
