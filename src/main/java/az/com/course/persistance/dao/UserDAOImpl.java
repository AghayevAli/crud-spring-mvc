package az.com.course.persistance.dao;


import az.com.course.persistance.entity.User;
import az.com.course.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=:username", User.class);
        query.setParameter("username", username);
        User user;
        try {
            user = query.getSingleResult();
            System.out.println(user);
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
