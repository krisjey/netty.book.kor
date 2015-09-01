package com.github.nettybook.ch9;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/hsqlApplicationContext.xml")
public class HsqlTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test() {
        List<Map<String, Object>> userList = sqlSession.selectList("users.list");
        for (Map<String, Object> user : userList) {
            assertNotNull(user.get("USERID"));
            assertNotNull(user.get("USERNAME"));
            assertNotNull(user.get("PASSWORD"));
        }
    }

}