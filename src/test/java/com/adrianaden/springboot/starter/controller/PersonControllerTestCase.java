package com.adrianaden.springboot.starter.controller;

import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.repository.PersonRepository;
import com.adrianaden.springboot.starter.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTestCase {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService personService;

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
    public void create() throws Exception {
        Mockito.when(personService.create(Mockito.any(Person.class)))
                .thenReturn(personMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/person")
                .contextPath("/api")
                .servletPath("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"address\": \"Orange Street 15\",\"firstName\": \"Jon\",\"gender\": \"M\",\"lastName\": \"Doe\"}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void update() throws Exception {
        Mockito.when(personService.create(Mockito.any(Person.class)))
                .thenReturn(personMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/person/1")
                .contextPath("/api")
                .servletPath("/person/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"address\": \"Orange Street 15\",\"firstName\": \"Jon\",\"gender\": \"M\",\"lastName\": \"Doe\"}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void patch() throws Exception {
        Mockito.when(personService.create(Mockito.any(Person.class)))
                .thenReturn(personMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch("/api/person/1")
                .contextPath("/api")
                .servletPath("/person/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"address\": \"Orange Street 15\",\"firstName\": \"Jon\",\"gender\": \"M\",\"lastName\": \"Doe\"}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void findOneById() throws Exception {
        Mockito.when(personService.create(Mockito.any(Person.class)))
                .thenReturn(personMock);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/person/1")
                .contextPath("/api")
                .servletPath("/person/1");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
