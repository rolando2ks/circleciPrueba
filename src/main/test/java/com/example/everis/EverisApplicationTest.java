package com.example.everis;

import com.example.everis.model.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EverisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EverisApplicationTest{

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateUser() {
        Usuario user = new Usuario();
        user.setName("admin");
        user.setPassword("adminDD22");
        user.setEmail("prueba@prueba.cl");

        ResponseEntity<Usuario> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, Usuario.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }
}