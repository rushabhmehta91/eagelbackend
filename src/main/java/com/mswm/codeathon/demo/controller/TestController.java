package com.mswm.codeathon.demo.controller;

import com.mswm.codeathon.demo.persistence.crudInterface.PersonsRepository;
import com.mswm.codeathon.demo.persistence.entity.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private final PersonsRepository personsRepository;
    private LdapTemplate ldapTemplate;

    public TestController(PersonsRepository personsRepository, TestController ldapTemplate) {
        this.personsRepository = personsRepository;
    }

    @GetMapping("ping")
    public ResponseEntity<String> sayHi() {
        return ResponseEntity.ok("Hello " + System.getProperty("CONFIG_MODE") + "!");
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Persons> getAllPersons() {
        return personsRepository.findAll();
    }

    @GetMapping(path = "/ldap")
    public @ResponseBody
    List<String> search(String username) {
        return ldapTemplate
                .search(
                        "ou=users",
                        "cn=rushabhm@lab.morganstanley.com",
                        (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }
}
