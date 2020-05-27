package az.com.course.persistance.dao;

import az.com.course.persistance.entity.User;

public interface UserDAO {
    User findByUsername(String username);
}
