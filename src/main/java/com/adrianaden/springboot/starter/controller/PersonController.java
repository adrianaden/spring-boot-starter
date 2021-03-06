package com.adrianaden.springboot.starter.controller;

import com.adrianaden.springboot.starter.common.Constant;
import com.adrianaden.springboot.starter.annotation.RequestDto;
import com.adrianaden.springboot.starter.dto.ResponseDto;
import com.adrianaden.springboot.starter.dto.PersonDto;
import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = Constant.PATH_PERSON)
class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    ResponseEntity<Page> findPage(Pageable pageable) {
        return ResponseEntity.ok(personService.findPage(pageable));
    }

    @GetMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Person> findOneById(@PathVariable(Constant.PATH_ID) Long id) {
        return ResponseEntity.ok(personService.findOneById(id));
    }

    @PostMapping
    ResponseDto<PersonDto> create(@RequestDto(PersonDto.class) @Validated Person person) {
        return ResponseDto.accepted().convertTo(personService.create(person), PersonDto.class);
    }

    @PutMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Person> update(@PathVariable(Constant.PATH_ID) Long id, @RequestBody @Validated Person person) {
        return ResponseEntity.ok(personService.update(id, person));
    }

    @PatchMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Person> patch(@PathVariable(Constant.PATH_ID) Long id, @RequestBody @Validated Person person) {
        return ResponseEntity.ok(personService.patch(id, person));
    }

    @DeleteMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Person> delete(@PathVariable(Constant.PATH_ID) Long id) {
        return ResponseEntity.ok(personService.delete(id));
    }

}
