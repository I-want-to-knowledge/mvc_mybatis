package com.jay.service;

import com.jay.dao.UserStateMapper;
import com.jay.entities.UserState;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.Date;

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
    private Logger LOG = LoggerFactory.getLogger(UserStateServiceImplTest.class);

    @Before
    public void setUp() {
        LOG.info("setup");
    }

    @After
    public void tearDown() {
        LOG.info("tearDown");
    }

    @Test
    public void insert() {
        // version1();

        // springmvc-mybatis
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        // 获得session对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            //映射层
            UserStateMapper mapper = sqlSession.getMapper(UserStateMapper.class);
            UserState userState = new UserState();
            userState.setId(0L);
            userState.setUserId(0L);
            userState.setType(0);
            userState.setLastTime(new Date());
            int insert = mapper.insert(userState);
            LOG.info("insert=" + insert);
        }

        LOG.info("插入完成！");
    }

    /**
     * 没有添加spring的mybatis
     */
    private void version1() {
        // mybatis链接sql配置
        InputStream stream = UserStateServiceImplTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        try (SqlSession session = factory.openSession(true)) {
            UserStateMapper userStateMapper = session.getMapper(UserStateMapper.class);
            UserState userState = new UserState();
            userState.setId(0L);
            userState.setUserId(0L);
            userState.setType(0);
            userState.setLastTime(new Date());
            int insert = userStateMapper.insert(userState);
            LOG.info("insert=" + insert);
            // List<UserState> userStates = userStateMapper.find();
            // userStates.forEach(userState1 -> System.out.println(userState1.toString()));
        }
    }

    @Test
    public void insertSelective() {
        LOG.info("insertSelective");
    }

    @Test
    public void insertList() {
        LOG.info("insertList");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        LOG.info("updateByPrimaryKeySelective");
    }
}
