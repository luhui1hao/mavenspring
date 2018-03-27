package com.luhui1hao.mybatis.mapper;

import com.luhui1hao.mybatis.bean.Order;
import com.luhui1hao.mybatis.bean.User;
import com.luhui1hao.mybatis.vo.QueryVo;

import java.util.List;

public interface UserMapper {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    List<User> queryUserByUsername1(String username);

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据包装类查询用户
     * @param vo
     * @return
     */
    List<User> queryUserByQueryVo(QueryVo vo);

    /**
     * 查询用户表数据条数
     * @return
     */
    int queryUserCount();

    /**
     * 查询订单表Order的所有数据
     */
    List<Order> queryOrderAll();

    /**
     * 根据性别和名字查询用户
     */
    List<User> queryUserByWhere(User user);

    /**
     * 根据多个id查询用户信息
     */
    List<User> queryUserByIds(QueryVo vo);

    /**
     * 根据多个id查询用户信息之数组
     */
    List<User> queryUserByIds2(Integer[] ids);

    /**
     * 根据多个id查询用户信息之List
     */
    List<User> queryUserByIds3(List<Integer> ids);

}
