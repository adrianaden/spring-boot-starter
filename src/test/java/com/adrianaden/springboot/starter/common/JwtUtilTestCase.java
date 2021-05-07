package com.adrianaden.springboot.starter.common;

import com.adrianaden.springboot.starter.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUtilTestCase {
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void generateToken() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Adrian");
        person.setLastName("Adendrata");
        String actual = jwtUtil.generateToken(person);
        log.info(actual);
        Assert.assertNotNull(actual);
    }

    @Test
    public void validateToken() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Adrian");
        person.setLastName("Adendrata");

        String token = jwtUtil.generateToken(person);
        log.info(token);
        Assert.assertNotNull(token);

        String lastName = jwtUtil.getClaims(token).get("personLastName").toString();
        String firstName = jwtUtil.getClaims(token).get("personFirstName").toString();
        Long personId = Long.parseLong(jwtUtil.getClaims(token).get("personId").toString());
        String id = jwtUtil.getClaims(token).getId();
        Date exp = jwtUtil.getClaims(token).getExpiration();
        log.info(exp.toString());

        Assert.assertEquals(person.getLastName(), lastName);
        Assert.assertEquals(person.getFirstName(), firstName);
        Assert.assertEquals(person.getId(), personId);
        Assert.assertEquals(person.getId().toString(), id);
    }
}
