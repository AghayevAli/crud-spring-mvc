package az.com.course.bean.person;

import az.com.course.bean.ResponseBean;
import az.com.course.model.Person;

import java.util.List;

public class PersonResponseBean extends ResponseBean {
    private List<Person> persons;

    @Override
    public String toString() {
        return "PersonResponseBean{" +
                "persons=" + persons +
                '}';
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
