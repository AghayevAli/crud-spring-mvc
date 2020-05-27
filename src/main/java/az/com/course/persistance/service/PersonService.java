package az.com.course.persistance.service;

import az.com.course.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> persons();

    void add(Person person);

    void update(Integer id,Person person);

    void remove(Integer id);

    Person findById(Integer id);
}
