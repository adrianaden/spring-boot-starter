package com.adrianaden.springboot.starter.service;

import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTestCase {

    @Autowired
    private PersonService personService;
    @MockBean
    private PersonRepository personRepository;

    private Person personMock;

    @Before
    public void preDefine() {
        personMock = new Person();
        personMock.setId(1L);
        personMock.setFirstName("Jon");
        personMock.setLastName("Due");
        personMock.setGender("M");
    }

    @Test
    public void create() {
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(personMock);
        Person actual = personService.create(personMock);

        Assert.assertNotNull(actual);
    }

    @Test
    public void update() {
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(personMock);

        Person actual = personService.update(1L, personMock);

        Assert.assertNotNull(actual);
        Assert.assertEquals(personMock, actual);
    }


    @Test
    public void patch() {
        Person person = new Person();
        person.setAddress("Orange Street");

        Optional<Person> personOptional = Optional.of(personMock);
        Mockito.when(personRepository.findById(Mockito.any(Long.class))).thenReturn(personOptional);
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(personMock);

        Person actual = personService.patch(1L, person);

        Assert.assertNotNull(actual);
        Assert.assertNotNull(actual.getId());
        Assert.assertNotNull(actual.getFirstName());
        Assert.assertNotNull(actual.getLastName());
        Assert.assertNotNull(actual.getGender());
        Assert.assertEquals("Orange Street", actual.getAddress());
    }


    @Test
    public void findOneById() {
        Optional<Person> personOptional = Optional.of(personMock);
        Mockito.when(personRepository.findById(Mockito.any(Long.class))).thenReturn(personOptional);

        Person actual = personService.findOneById(1L);

        Assert.assertNotNull(actual);
        Assert.assertEquals(personOptional.get().getId(), actual.getId());
    }
}
