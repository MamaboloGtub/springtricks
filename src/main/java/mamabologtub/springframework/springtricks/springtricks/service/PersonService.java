package mamabologtub.springframework.springtricks.springtricks.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import mamabologtub.springframework.springtricks.springtricks.model.Person;

/**
 * Tshepo M Mahudu
 */

@Service
public class PersonService {
    public String getPerson() {
        JSONObject returnObj = new JSONObject();

        Person person = new Person();
        person.setAge("21");
        person.setName("Tshepo");
        person.setCity("Polokwane");

        returnObj.put("age", person.getAge());
        returnObj.put("name", person.getName());
        returnObj.put("city", person.getCity());

        return returnObj.toString();

    }

}
