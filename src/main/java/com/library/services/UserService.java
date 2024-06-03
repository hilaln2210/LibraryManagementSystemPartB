package com.library.services;

import com.library.dao.IDao;
import com.library.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private IDao<User> userDao;

    public UserService(IDao<User> userDao) {
        this.userDao = userDao;
    }

    public void registerUser(User user) {
        userDao.add(user);
    }

    public User getUserById(int id) {
        return userDao.get(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public List<User> getUsersByName(String name) {
        return userDao.getAll().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }
}
