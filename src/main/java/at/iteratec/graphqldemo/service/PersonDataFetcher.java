package at.iteratec.graphqldemo.service;

import at.iteratec.graphqldemo.model.Person;
import at.iteratec.graphqldemo.repository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ben on 2017-06-13.
 */
@Component
public class PersonDataFetcher implements DataFetcher<Person> {

    @Autowired
    private PersonRepository repository;

    @Override
    public Person get(DataFetchingEnvironment dataFetchingEnvironment) {
        String name = dataFetchingEnvironment.getArgument("name");

        return repository.findByName(name);
    }
}
