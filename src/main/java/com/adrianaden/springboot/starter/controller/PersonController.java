package com.adrianaden.springboot.starter.controller;

import com.adrianaden.springboot.starter.common.Constant;
import com.adrianaden.springboot.starter.dto.SuccessResponse;
import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = Constant.PATH_PERSON)
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    ResponseEntity<SuccessResponse> findPage(Pageable pageable) {

        Object data = personService.findPage(pageable);
        String message = "success find page person";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }

    @GetMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<SuccessResponse> findOneById(@PathVariable("id") Long id) {

        Object data = personService.findOneById(id);
        String message = "success find person by id";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }

    @PostMapping
    ResponseEntity<SuccessResponse> create(@RequestBody @Validated Person person) {

        Object data = personService.create(person);
        String message = "success create person";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }

    @PutMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id, @RequestBody @Validated Person person) {

        Object data = personService.update(id, person);
        String message = "success update person";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }

    @PatchMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<SuccessResponse> patch(@PathVariable("id") Long id, @RequestBody @Validated Person person) {

        Object data = personService.patch(id, person);
        String message = "success patch person";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }

    @DeleteMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<SuccessResponse> delete(@PathVariable("id") Long id) {

        Object data = personService.delete(id);
        String message = "success delete person";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }

}
