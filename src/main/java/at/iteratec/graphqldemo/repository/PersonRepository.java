package at.iteratec.graphqldemo.repository;

import at.iteratec.graphqldemo.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 2017-06-13.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByName(String name);
}
