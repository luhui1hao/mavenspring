package com.luhui1hao.mybatis;

import com.luhui1hao.mybatis.bean.Order;
import com.luhui1hao.mybatis.bean.OrderUser;
import com.luhui1hao.mybatis.bean.User;
import com.luhui1hao.mybatis.mapper.OrderMapper;
import com.luhui1hao.mybatis.mapper.UserMapper;
import com.luhui1hao.mybatis.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.weaver.ast.Or;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
     *
     * @throws Exception
     */
    @Test
    public void testQueryUserById() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        Object user = sqlSession.selectOne("queryUserById", 2);

        // 6. 打印结果
        System.out.println("-------------------------------------------");
        System.out.println(user);
        System.out.println("-------------------------------------------");

        // 7. 释放资源
        sqlSession.close();
    }

    /**
     * 根据用户名模糊查询用户（方法一）
     *
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
     *
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

    /**
     * 添加用户
     */
    @Test
    public void testSaveUser() {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行保存
        // 创建需要保存的User
        User user = new User();
        user.setUsername("赵云");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("蜀国");

        sqlSession.insert("saveUser", user);
        System.out.println(user);

        // 需要进行事务提交
        sqlSession.commit();

        // 7. 释放资源
        sqlSession.close();
    }

    /**
     * 修改用户
     */
    @Test
    public void testUpdateUserById() {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行更新
        // 创建需要更新的User
        User user = new User();
        user.setId(1);
        user.setSex("女");

        sqlSession.update("updateUserById", user);

        // 需要进行事务提交
        sqlSession.commit();

        // 7. 释放资源
        sqlSession.close();
    }

    /**
     * 删除用户
     */
    @Test
    public void testDeleteUserById() {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行删除
        sqlSession.delete("deleteUserById", 1);

        // 需要进行事务提交
        sqlSession.commit();

        // 7. 释放资源
        sqlSession.close();
    }

    /**
     * 根据包装类查询用户
     */
    @Test
    public void testueryUserByQueryVo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("六");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> users = sqlSession.selectList("queryUserByQueryVo", vo);

        for (User entity : users) {
            System.out.println(entity);
        }

        sqlSession.close();
    }

    /**
     * 查询User表中数据的人条数
     */
    @Test
    public void testueryUserCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int count = sqlSession.selectOne("queryUserCount");

        System.out.println("已有用户" + count + "人");
        sqlSession.close();
    }

    /**
     * 查询订单表Order的所有数据
     */
    @Test
    public void testQueryOrderAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Order> orders = sqlSession.selectList("queryOrderAll");

        for (Order entity : orders) {
            System.out.println(entity);
        }
    }

    /**
     * 根据性别和名字查询用户
     */
    @Test
    public void testqueryUserByWhere() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("六");
        user.setSex("男");
        List<User> users = sqlSession.selectList("queryUserByWhere", user);

        for (User entity : users) {
            System.out.println(entity);
        }
    }

    /**
     * 根据多个Id查询用户
     */
    @Test
    public void testqueryUserByIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //传入对象
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        QueryVo vo = new QueryVo();
        vo.setIds(ids);
        List<User> users = mapper.queryUserByIds(vo);

        for (User entity : users) {
            System.out.println(entity);
        }

        System.out.println("------------------------------");

        //传入数组
        Integer[] ids2 = new Integer[]{1,2,3};
        List<User> users2 = mapper.queryUserByIds2(ids2);

        for (User entity : users2) {
            System.out.println(entity);
        }

        System.out.println("------------------------------");

        //传入List
        List<Integer> ids3 = new ArrayList<Integer>();
        ids3.add(1);
        ids3.add(2);
        ids3.add(3);
        List<User> users3 = mapper.queryUserByIds3(ids3);

        for (User entity : users3) {
            System.out.println(entity);
        }
    }

    /**
     * 查询所有订单信息，关联查询下单用户信息——方法一
     */
    @Test
    public void testQueryOrderUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<OrderUser> orderUsers = mapper.queryOrderUser();

        for (OrderUser entity : orderUsers) {
            System.out.println(entity);
        }
    }

    /**
     * 查询所有订单信息，关联查询下单用户信息——方法二
     */
    @Test
    public void testQueryOrderUserResultMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = mapper.queryOrderUserResultMap();

        for (Order entity : orders) {
            System.out.println(entity);
        }
    }
}
