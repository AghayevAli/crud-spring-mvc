package az.com.course.persistance.service;

import az.com.course.model.Person;
import az.com.course.persistance.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> persons() {
        return personDAO.persons();
    }

    @Override
    public void add(Person person) {
        personDAO.add(person);
    }

    @Override
    public void update(Integer id, Person person) {
        personDAO.update(id, person);
    }

    @Override
    public Person findById(Integer id) {
        return personDAO.findById(id);
    }

    @Override
    public void remove(Integer id) {
        personDAO.remove(id);
    }
}
