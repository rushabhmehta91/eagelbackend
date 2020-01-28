package com.mswm.codeathon.demo.controller;

import com.mswm.codeathon.demo.persistence.crudInterface.PersonsRepository;
import com.mswm.codeathon.demo.persistence.entity.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private final PersonsRepository personsRepository;

    public TestController(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @GetMapping("ping")
    public ResponseEntity<String> sayHi() {
        return ResponseEntity.ok("Hello!");
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Persons> getAllPersons() {
        return personsRepository.findAll();
    }
}
