package com.github.nettybook.ch9;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class HsqlTest {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test() {
        List<Map<String, Object>> userList = sqlSession.selectList("users.list");
        for (Map<String, Object> user : userList) {
            assertNotNull(user.get("UESRID"));
            assertNotNull(user.get("USERNAME"));
            assertNotNull(user.get("PASSWORD"));
        }
    }

}