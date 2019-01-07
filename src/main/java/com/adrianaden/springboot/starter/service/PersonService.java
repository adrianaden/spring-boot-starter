package com.adrianaden.springboot.starter.service;

import com.adrianaden.springboot.starter.common.Tool;
import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PersonService {

    /**
     * find all person
     *
     * @param xPageable the page, set 'null' to get all data
     * @return the page of person
     */
    Page<Person> findPage(Pageable xPageable);

    /**
     * find person by Id
     *
     * @param xID the person id
     * @return one person
     */
    Person findOneById(Long xID);

    /**
     * update all field in person by id
     *
     * @param xID     the person id
     * @param xPerson person to be update
     * @return updated person
     */
    Person update(Long xID, Person xPerson);

    /**
     * patch specific field in person by id
     *
     * @param xID     the person id
     * @param xPerson person to be update
     * @return updated person
     */
    Person patch(Long xID, Person xPerson);

    /**
     * create new person
     *
     * @param xPerson the person to be create
     * @return created person
     */
    Person create(Person xPerson);

    /**
     * delete person by id
     *
     * @param xID the person id
     * @return deleted person
     */
    Person delete(Long xID);

}
