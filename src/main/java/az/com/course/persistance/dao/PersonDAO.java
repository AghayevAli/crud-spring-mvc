package az.com.course.persistance.dao;

import az.com.course.model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> persons();

    void add(Person person);

    void update(Integer id,Person person);

    void remove(Integer id);

    Person findById(Integer id);
}
