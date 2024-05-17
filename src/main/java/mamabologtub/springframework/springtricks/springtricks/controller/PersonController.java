package mamabologtub.springframework.springtricks.springtricks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import mamabologtub.springframework.springtricks.springtricks.annotations.JSONGetMapping;
import mamabologtub.springframework.springtricks.springtricks.service.PersonService;

/**
 * Tshepo M Mahudu
 */

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @JSONGetMapping(value = "/person", produces = "application/json")
    public String getPerString() {
        return service.getPerson();
    }

}
