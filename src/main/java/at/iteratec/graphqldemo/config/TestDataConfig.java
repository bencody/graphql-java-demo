package at.iteratec.graphqldemo.config;

import at.iteratec.graphqldemo.model.Person;
import at.iteratec.graphqldemo.model.Role;
import at.iteratec.graphqldemo.repository.PersonRepository;
import at.iteratec.graphqldemo.repository.RoleRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by Ben on 2017-06-13.
 */
@Configuration
public class TestDataConfig {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @PostConstruct
    public void init() {

        Role admin = new Role("Admin");
        Role developer = new Role("Developer");
        Role tester = new Role("Tester");
        Role analyst = new Role("Analyst");

        roleRepository.save(admin);
        roleRepository.save(developer);
        roleRepository.save(tester);
        roleRepository.save(analyst);

        Person alice = new Person();
        alice.setName("Alice");
        alice.setRoles(Sets.newHashSet(admin));

        Person bob = new Person();
        bob.setName("Bob");
        bob.setRoles(Sets.newHashSet(developer, tester));

        Person charlie = new Person();
        charlie.setName("Charlie");
        charlie.setRoles(Sets.newHashSet(analyst, tester));

        alice.setFriends(Sets.newHashSet(bob, charlie));
        charlie.setFriends(Sets.newHashSet(bob));

        personRepository.save(bob);
        personRepository.save(charlie);
        personRepository.save(alice);
    }
}
