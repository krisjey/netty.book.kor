package com.github.nettybook.ch9;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class UserDaoTest {
	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/create-table.sql")
				.addScript("db/sql/insert-data.sql")
				.setName("NETTY_EXAMPLE_DB")
				.build();
	}

	@Test
	public void testFindByname() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
//		UserDaoImpl userDao = new UserDaoImpl();
//		userDao.setNamedParameterJdbcTemplate(template);
//
//		User user = userDao.findByName("Kris jey");
//
//		Assert.assertNotNull(user);
//		Assert.assertEquals(1, user.getId().intValue());

	}

	@After
	public void tearDown() {
		db.shutdown();
	}

}