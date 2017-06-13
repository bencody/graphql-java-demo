package at.iteratec.graphqldemo.repository;

import at.iteratec.graphqldemo.model.Person;
import at.iteratec.graphqldemo.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 2017-06-13.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
