package az.com.course.controller;

import az.com.course.bean.person.PersonResponseBean;
import az.com.course.model.Person;
import az.com.course.persistance.service.PersonService;
import az.com.course.util.JwtTokenUtil;
import az.com.course.util.exception.NegativeIndexValue;
import az.com.course.util.exception.TokenIsEmpty;
import az.com.course.util.exception.UserNotFoundException;
import az.com.course.util.responseBody.ResponseBodyCodeAndMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static final Logger logger = Logger.getLogger(PersonController.class);

    @GetMapping("/")
    public PersonResponseBean persons(@RequestHeader("Authorization") String token) {

        if (token.trim().isEmpty())
            throw new TokenIsEmpty();
        String username = jwtTokenUtil.getUsernameFromToken(token);
        PersonResponseBean personResponseBean = new PersonResponseBean();
        List<Person> persons = personService.persons();
        personResponseBean.setCode(ResponseBodyCodeAndMessage.SUCCESS.getCode());
        personResponseBean.setMessage(ResponseBodyCodeAndMessage.SUCCESS_MESSAGE.getMessage());
        personResponseBean.setPersons(persons);
        return personResponseBean;
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public void add(@RequestBody Person person) {
        logger.info("PostMapping start " + "Mapping person is: " + person);
        personService.add(person);
    }

    @PutMapping(value = "{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Person person) {
        logger.info("PutMapping start " + "Mapping person is: " + person + " and id is : " + id);
        personService.update(id, person);
    }

    @DeleteMapping(value = "/")
    public void remove(@RequestParam("id") Integer id) {
        personService.remove(id);
    }

    @GetMapping(value = "{id}")
    public Person findById(@PathVariable("id") Integer id) {
        if (id < 0)
            throw new NegativeIndexValue();
        Person byId = personService.findById(id);
        if (Objects.isNull(byId)) {
            throw new UserNotFoundException();
        }
        return byId;
    }


}
