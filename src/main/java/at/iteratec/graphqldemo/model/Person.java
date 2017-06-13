package at.iteratec.graphqldemo.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ben on 2017-06-13.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany
    private Set<Person> friends;

    @ManyToMany
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
