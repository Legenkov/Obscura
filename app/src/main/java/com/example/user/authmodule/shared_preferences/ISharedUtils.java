package com.example.user.authmodule.shared_preferences;

import com.example.user.authmodule.model.User;

import java.util.List;

/**
 * Created by User on 18.04.2018.
 */

public interface ISharedUtils {
    void init();
    List<User> getUsers();
    void addUser(User user);
    void removeUser(User user);
    void removeUsers();
    void saveUsers(List <User> users);
}