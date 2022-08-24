package com.magadiflo.app.api;

import com.magadiflo.app.domain.Role;
import com.magadiflo.app.domain.User;
import com.magadiflo.app.dto.RoleToUserFormDto;
import com.magadiflo.app.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v0/users")
public class UserResource {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(this.userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v0/users").toUriString());
        return ResponseEntity.created(uri).body(this.userService.saveUser(user));
    }

    @PostMapping(path = "/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v0/users/role").toUriString());
        return ResponseEntity.created(uri).body(this.userService.saveRole(role));
    }

    @PostMapping(path = "/role-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserFormDto form) {
        this.userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}
