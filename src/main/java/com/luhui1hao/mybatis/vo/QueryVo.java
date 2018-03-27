package com.luhui1hao.mybatis.vo;

import com.luhui1hao.mybatis.bean.User;

import java.util.List;

public class QueryVo {
    // 包含其他的pojo
    private User user;

    private List<Integer> ids;

    private Integer[] ids2;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer[] getIds2() {
        return ids2;
    }

    public void setIds2(Integer[] ids2) {
        this.ids2 = ids2;
    }
}
