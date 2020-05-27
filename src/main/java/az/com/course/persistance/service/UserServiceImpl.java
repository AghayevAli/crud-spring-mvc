package az.com.course.persistance.service;

import az.com.course.persistance.dao.UserDAO;
import az.com.course.persistance.entity.User;
import az.com.course.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
