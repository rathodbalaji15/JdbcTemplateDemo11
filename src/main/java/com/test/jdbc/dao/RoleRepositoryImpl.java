package com.test.jdbc.dao;

import com.test.jdbc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    //    private static final String INSERT_ROLE_QUERY=
    private static final String UPDATE_BY_ID_ROLE_QUERY = "UPDATE ROLE_CONFIGURATIONS SET ROLE_NAME=? WHERE ID=?";
    private static final String GET_ROLE_BY_ID_QUERY = "SELECT * FROM ROLE_CONFIGURATIONS WHERE ID='?';";
    private static final String GET_ROLES_QUERY = "SELECT * FROM ROLE_CONFIGURATIONS";
    public static final String FETCH_ACTIVE_ROLE_NAMES_QUERY = "SELECT ROLE_NAME FROM ROLE_CONFIGURATIONS WHERE IS_ACTIVATED='Y';";


    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Override
//    public Role saveRole(Role role) {
//        return null;
//    }

    @Override
    public Role updateRole(Role role) {
        jdbcTemplate.update(UPDATE_BY_ID_ROLE_QUERY, role.getRole_name(), role.getId());
        return role;
    }

    @Override
    public Role getById(int id) {
        return jdbcTemplate.queryForObject(GET_ROLE_BY_ID_QUERY, (rs, rowNum) -> {
            return new Role(rs.getInt("id"), rs.getString("role_name"),
                    rs.getString("additional_info"), rs.getInt("daily_limit_per_customer"),
                    rs.getInt("daily_limit_per_staff_user"), rs.getInt("gift_value_cap"),
                    rs.getString("is_activated"), rs.getString("role_description"));

        });

    }

    @Override
    public List<String> getByIsActivated() {
        List<String> names=jdbcTemplate.queryForList(FETCH_ACTIVE_ROLE_NAMES_QUERY,String.class);
        List<String> filteredNames = names.stream().filter(name -> !name.equals("Admin")).collect(Collectors.toList());
//        String sql = "SELECT role_name FROM role_configurations WHERE is_activated = true";
//        List<String> activeRoleNames = jdbcTemplate.queryForList(sql, String.class);
//        System.out.println("Name of Person>>"+activeRoleNames);
       return filteredNames;
    }


//@Override

//    @Override
//    public List<String> getByIsActivated() {
//        return jdbcTemplate.query(FETCH_ACTIVE_ROLE_NAMES_QUERY, (rs, rowNum)->{
//            return rs.getNString("role_name");
//        });
//    }





//    @Override
//    public Role deleteById(int id) {
//        return null;
//    }

    @Override
    public List<Role> allRoles() {
        return jdbcTemplate.query(GET_ROLES_QUERY, (rs, rowNum) -> {
            return new Role(rs.getInt("id"), rs.getString("role_name"),
                    rs.getString("additional_info"), rs.getInt("daily_limit_per_customer"),
                    rs.getInt("daily_limit_per_staff_user"), rs.getInt("gift_value_cap"),
                    rs.getString("is_activated"), rs.getString("role_description"));

        });
    }
}
