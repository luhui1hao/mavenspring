package com.luhui1hao.aopdemo.serviceImpl;

import com.luhui1hao.aopdemo.service.UserService;

public class UserServiceImpl implements UserService {
    public void insert() {
        System.out.println("插入数据");
    }

    public void delete() {
        System.out.println("删除数据");
    }

    public void update() {
        System.out.println("更新数据");
    }

    public void query() {
        System.out.println("查询数据");
    }
}
