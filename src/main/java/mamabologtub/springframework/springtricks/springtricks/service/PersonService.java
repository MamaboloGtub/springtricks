package mamabologtub.springframework.springtricks.springtricks.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mamabologtub.springframework.springtricks.springtricks.model.Person;
import mamabologtub.springframework.springtricks.springtricks.repository.PersonRepository;

/**
 * Tshepo M Mahudu
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository repo;

    public String getPerson(Long id) {
        JSONObject returnObj = new JSONObject();

        Person person = repo.findPersonById(id);
        returnObj.put("id", person.getId());
        returnObj.put("age", person.getAge());
        returnObj.put("name", person.getName());
        returnObj.put("city", person.getCity());

        return returnObj.toString();

    }

    public String getAllPeople() {
        JSONObject returnObject = new JSONObject();
        JSONArray returnArray = new JSONArray();

        ArrayList<Person> allPeople = repo.findAll();
        for (Person currentPerson: allPeople) {
            JSONObject currentObject = new JSONObject();
            currentObject.put("id", currentPerson.getId());
            currentObject.put("name", currentPerson.getName());
            currentObject.put("age", currentPerson.getAge());
            currentObject.put("city", currentPerson.getCity());
            returnArray.put(currentObject);
        }
        returnObject.put("content", returnArray);
        return returnObject.toString();
    }

    public String createPerson(String payload) throws Exception {
        JSONObject payloadObject = new JSONObject(payload);

        if (!payloadObject.has("name") || !payloadObject.has("age") || !payloadObject.has("city")) {
            throw new Exception("All three variables must be present");
        }

        Person person = new Person();
        person.setName(payloadObject.getString("name"));
        person.setAge(payloadObject.getString("age"));
        person.setCity(payloadObject.getString("city"));

        repo.save(person);
        return payloadObject.toString();

    }

}
