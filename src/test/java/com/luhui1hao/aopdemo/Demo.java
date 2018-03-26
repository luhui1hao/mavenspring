package com.luhui1hao.aopdemo;

import com.luhui1hao.aopdemo.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    @Resource(name = "userService")
    private UserServiceImpl userService;

    @Test
    public void test() {
        userService.insert();
        userService.delete();
        userService.update();
        userService.query();
    }
}
