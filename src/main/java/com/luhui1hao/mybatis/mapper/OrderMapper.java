package com.luhui1hao.mybatis.mapper;

import com.luhui1hao.mybatis.bean.Order;
import com.luhui1hao.mybatis.bean.OrderUser;

import java.util.List;

public interface OrderMapper {
    //一对一查询
    /**
     * 查询所有订单信息，关联查询下单用户信息——方法一
     *
     * 使用resultType，改造订单pojo类，此pojo类中包括了订单信息和用户信息
     * 这样返回对象的时候，mybatis自动把用户信息也注入进来了
     */
    List<OrderUser> queryOrderUser();

    /**
     * 查询所有订单信息，关联查询下单用户信息——方法二
     *
     * 在Order类中加入User属性，
     * user属性中用于存储关联查询的用户信息，
     * 因为订单关联查询用户是一对一关系，所以这里使用单个User对象存储关联查询的用户信息。
     */
    List<Order> queryOrderUserResultMap();
}
