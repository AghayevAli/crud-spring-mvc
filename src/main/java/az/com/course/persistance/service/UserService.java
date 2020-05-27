package az.com.course.persistance.service;

import az.com.course.persistance.entity.User;

public interface UserService {
    User findByUsername(String username);
}
