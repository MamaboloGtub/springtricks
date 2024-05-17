package mamabologtub.springframework.springtricks.springtricks.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import mamabologtub.springframework.springtricks.springtricks.model.Person;

/**
 * Tshepo M Mahudu
 */

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Override
    ArrayList<Person> findAll();
    Person findPersonById(Long id);
}
