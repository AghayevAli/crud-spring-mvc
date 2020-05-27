package az.com.course.persistance.dao;

import az.com.course.model.Person;
import az.com.course.persistance.entity.PersonEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> persons() {
        List<PersonEntity> entityPersons = entityManager.createQuery("select p from PersonEntity p").getResultList();
        List<Person> persons = new ArrayList<>();
        for (PersonEntity personEntity : entityPersons) {
            Person person = new Person();
            person.setId(personEntity.getUser_id());
            person.setName(personEntity.getName());
            person.setSurname(personEntity.getSurname());
            persons.add(person);
        }
        return persons;
    }

    @Override
    @Transactional
    public void add(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUser_id(person.getId());
        personEntity.setName(person.getName());
        personEntity.setSurname(person.getSurname());
        entityManager.persist(personEntity);
    }

    @Override
    @Transactional
    public void update(Integer id, Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUser_id(person.getId());
        personEntity.setName(person.getName());
        personEntity.setSurname(person.getSurname());
        PersonEntity personEntity1 = entityManager.find(PersonEntity.class, id);
        System.out.println(personEntity.getName());
        System.out.println(personEntity.getSurname());
        personEntity1.setName(personEntity.getName());
        personEntity1.setSurname(personEntity.getSurname());
    }

    @Override
    public Person findById(Integer id) {
        PersonEntity personEntity = entityManager.find(PersonEntity.class, id);
        if (Objects.isNull(personEntity)) {
            return null;
        }
        return new Person(personEntity.getUser_id(), personEntity.getName(), personEntity.getSurname());
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        PersonEntity personEntity = entityManager.find(PersonEntity.class, id);
        entityManager.remove(personEntity);
    }
}
