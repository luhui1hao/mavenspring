package com.luhui1hao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    /**
     * 根据id查询用户
     * @throws Exception
     */
    @Test
    public void testQueryUserById() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        Object user = sqlSession.selectOne("queryUserById", 1);

        // 6. 打印结果
        System.out.println("-------------------------------------------");
        System.out.println(user);
        System.out.println("-------------------------------------------");

        // 7. 释放资源
        sqlSession.close();
    }

    /**
     * 根据用户名模糊查询用户（方法一）
     * @throws Exception
     */
    @Test
    public void testQueryUserByUsername1() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 查询多条数据使用selectList方法
        List<Object> list = sqlSession.selectList("queryUserByUsername1", "%六%");

        // 6. 打印结果
        for (Object user : list) {
            System.out.println(user);
        }

        // 7. 释放资源
        sqlSession.close();
    }

    /**
     * 根据用户名模糊查询用户（方法二）
     * @throws Exception
     */
    @Test
    public void testQueryUserByUsername2() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 查询多条数据使用selectList方法
        List<Object> list = sqlSession.selectList("queryUserByUsername2", "六");

        // 6. 打印结果
        for (Object user : list) {
            System.out.println(user);
        }

        // 7. 释放资源
        sqlSession.close();
    }


}
