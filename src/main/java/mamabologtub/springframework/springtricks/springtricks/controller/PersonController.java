package mamabologtub.springframework.springtricks.springtricks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mamabologtub.springframework.springtricks.springtricks.service.PersonService;

/**
 * Tshepo M Mahudu
 */

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String getPerString() {
        return service.getPerson();
    }

}
