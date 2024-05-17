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
    public String createPerson(String payload) throws Exception {
        JSONObject payloadObject = new JSONObject(payload);
        JSONObject returnObject = new JSONObject();

        if (!payloadObject.has("name") || !payloadObject.has("age") || !payloadObject.has("city")) {
            throw new Exception("All three variables must be present");
        }
        returnObject.put("name", payloadObject.getString("name"));
        returnObject.put("age", payloadObject.getString("age"));
        returnObject.put("city", payloadObject.getString("city"));

        return returnObject.toString();

    }

}
