package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUserById(int id);

    void deleteUserById(int id);

    Set<Role> getRolesById(String rolesId);

}
