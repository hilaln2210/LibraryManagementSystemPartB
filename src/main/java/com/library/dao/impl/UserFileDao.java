package com.library.dao.impl;

import com.library.dao.IDao;
import com.library.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileDao implements IDao<User> {
    private String filePath;

    public UserFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getId() + "," + user.getName() + "," + user.getEmail());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) {
        return getAll().stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int userId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    users.add(new User(userId, name, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void delete(int id) {
        List<User> users = getAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                if (user.getId() != id) {
                    writer.write(user.getId() + "," + user.getName() + "," + user.getEmail());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
