package com.test.jdbc.controller;

import com.test.jdbc.dao.RoleRepository;
import com.test.jdbc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleRepository roleRepository;
    @PutMapping("/role")
    public Role updateRole(Role role){
        return roleRepository.updateRole(role);
    }
    @GetMapping("/roled/{id}")
    public Role getById(@PathVariable("id") int id){
        return roleRepository.getById(id);
    }
    @GetMapping("/role")
    public List<Role> getAllRoles(){
        return roleRepository.allRoles();
    }
    @GetMapping("/active")
    public List<String> getAllRolesNames(){
        return roleRepository.getByIsActivated();
    }
}
