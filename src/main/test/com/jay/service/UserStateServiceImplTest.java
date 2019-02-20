package com.jay.service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.jay.dao.UserStateMapper;
import com.jay.entities.UserState;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 测试类
 *
 * @author YanZhen
 * @since 2019-02-20 11:08
 */
//配置spring和junit整合，这样junit在启动时就会加载spring容器
// @RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
// @ContextConfiguration({"classpath:mybatis/mybatis.xml"})
public class UserStateServiceImplTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void insert() {
        // mybatis链接sql配置
        InputStream stream = UserStateServiceImplTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession(true);
        try {
            UserStateMapper userStateMapper = session.getMapper(UserStateMapper.class);
            UserState userState = new UserState();
            userState.setId(0L);
            userState.setUserId(0L);
            userState.setType(0);
            userState.setLastTime(new Date());
            int insert = userStateMapper.insert(userState);
            System.out.println("insert=" + insert);
            // List<UserState> userStates = userStateMapper.find();
            // userStates.forEach(userState1 -> System.out.println(userState1.toString()));
        } finally {
            session.close();
        }

        System.out.println("插入完成！");
    }

    @Test
    public void insertSelective() {
        System.out.println("insertSelective");
    }

    @Test
    public void insertList() {
        System.out.println("insertList");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("updateByPrimaryKeySelective");
    }
}
