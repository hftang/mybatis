package com.hftang.mybatis.pojo;

import java.util.List;

/**
 * 包装一层
 */
public class QueryVo {

    private User user;

    private List<Integer> userIds;


    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
