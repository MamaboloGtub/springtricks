package mamabologtub.springframework.springtricks.springtricks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mamabologtub.springframework.springtricks.springtricks.annotations.JSONGetMapping;
import mamabologtub.springframework.springtricks.springtricks.annotations.JSONPostMapping;
import mamabologtub.springframework.springtricks.springtricks.service.PersonService;

/**
 * Tshepo M Mahudu
 */

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @JSONGetMapping(value = "/person")
    public String getPerson() {
        return service.getAllPeople();
    }

    @JSONGetMapping(value = "/person/{id}")
    public String getPerson(@PathVariable Long id) {
        return service.getPerson(id);
    }

    @JSONPostMapping(value = "/person")
    public String createPerson(@RequestBody String payload) throws Exception {
        return service.createPerson(payload);
    }

}
