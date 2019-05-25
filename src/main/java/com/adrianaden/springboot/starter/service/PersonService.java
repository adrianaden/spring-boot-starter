package com.adrianaden.springboot.starter.service;

import com.adrianaden.springboot.starter.common.util.Copy;
import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    /**
     * find all person
     *
     * @param xPageable the page, set 'null' to get all data
     * @return the page of person
     */
    public Page<Person> findPage(Pageable xPageable) {
        return personRepository.findAll(xPageable);
    }

    /**
     * find person in object
     *
     * @param xID the person id
     * @return one person
     */
    public Person findOneById(Long xID) {
        return personRepository.findById(xID).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create new person
     *
     * @param xPerson the person to be create
     * @return created person
     */
    public Person create(Person xPerson) {
        return personRepository.save(xPerson);
    }


    /**
     * update all field in person by id
     *
     * @param xID     the person id
     * @param xPerson person to be update
     * @return updated person
     */
    public Person update(Long xID, Person xPerson) {
        xPerson.setId(xID);
        return personRepository.save(xPerson);
    }

    /**
     * patch specific field in person by id
     *
     * @param xID     the person id
     * @param xPerson person to be update
     * @return updated person
     */
    public Person patch(Long xID, Person xPerson) {
        Person person = findOneById(xID);
        Copy.copyNonNullProperties(xPerson, person);

        return personRepository.save(person);
    }

    /**
     * delete person by id
     *
     * @param xID the person id
     * @return deleted person
     */
    public Person delete(Long xID) {
        Person person = findOneById(xID);
        personRepository.delete(person);
        return person;
    }

}
