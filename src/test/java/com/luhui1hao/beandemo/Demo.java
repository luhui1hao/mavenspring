package com.luhui1hao.beandemo;

import com.luhui1hao.beandemo.bean.ComplexData;
import com.luhui1hao.beandemo.bean.User;
import com.luhui1hao.beandemo.bean.User2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    @Resource(name = "user2")
    private User2 user2;
    @Resource(name = "complexdata")
    private ComplexData complexData;

    @Test
    //获取通过配置文件导入的Bean对象
    public void test() {
        //从类路径下加载配置文件的方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    //获取通过注解导入的Bean对象
    public void test2() {
        System.out.println(user2);
    }

    @Test
    //复杂类型的注入
    public void test3() {
        System.out.println(complexData);
    }

}
