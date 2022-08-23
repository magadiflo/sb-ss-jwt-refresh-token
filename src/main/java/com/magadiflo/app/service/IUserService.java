package com.magadiflo.app.service;

import com.magadiflo.app.domain.Role;
import com.magadiflo.app.domain.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

}
