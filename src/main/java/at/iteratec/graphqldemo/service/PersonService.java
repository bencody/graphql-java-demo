package at.iteratec.graphqldemo.service;

import at.iteratec.graphqldemo.model.Person;
import at.iteratec.graphqldemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ben on 2017-06-13.
 */
@Component
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    public Person findByName(String name) {
        return repository.findByName(name);
    }
}
