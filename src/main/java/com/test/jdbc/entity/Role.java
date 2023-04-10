package com.test.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private int id;
    private String role_name;
    private String additional_info;
    private int daily_limit_per_customer;
    private int daily_limit_per_staff_user;
    private int gift_value_cap;
    private String is_activated;
    private String role_description;

}
