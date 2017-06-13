package at.iteratec.graphqldemo.service;

import at.iteratec.graphqldemo.model.Person;
import at.iteratec.graphqldemo.repository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Ben on 2017-06-13.
 */
@Component
public class PersonDataFetcher implements DataFetcher<Person> {

    @Autowired
    private PersonService service;

    @Override
    public Person get(DataFetchingEnvironment dataFetchingEnvironment) {
        String name = dataFetchingEnvironment.getArgument("name");

        Person person = service.findByName(name);
        return person;
    }
}
