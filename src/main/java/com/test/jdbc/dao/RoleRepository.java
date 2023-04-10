package com.test.jdbc.dao;

import com.test.jdbc.entity.Role;

import java.util.List;

public interface RoleRepository {
//    public Role saveRole(Role role);
    public Role updateRole(Role role);
    public Role getById(int id);
 List<String> getByIsActivated();
//    Role deleteById(int id);

    List<Role> allRoles();

}
