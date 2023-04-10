package com.test.jdbc;

import com.test.jdbc.dao.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static com.test.jdbc.dao.RoleRepositoryImpl.FETCH_ACTIVE_ROLE_NAMES_QUERY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JdbcTemplateDemo11ApplicationTests {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {

	}
	@Test
	public void getActiveRoleNames(){
		List<String> activeRoles =jdbcTemplate.query(FETCH_ACTIVE_ROLE_NAMES_QUERY,String.class);

		AssertThat(activeRoles).size().isGreaterThan(0);


		}

	}


