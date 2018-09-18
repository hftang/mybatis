package com.hftang.mybatis.pojo;

/**
 * 订单关联用户的 pojo
 */
public class OrderUser extends User {
    private String username;
    private String address;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
