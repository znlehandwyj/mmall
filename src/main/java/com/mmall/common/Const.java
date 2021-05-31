package com.mmall.common;

/**
 * Created by Steven.Lu on 2018/6/19.
 */
public class Const {
    public static final String CURRENT_USER="currentUser";

    public static final String EMAIL="email";
    public static final String USERNAME="username";

    public interface  Role{
        int ROLE_CUSTOMER=0;       //普通角色
        int ROLE_ADMIN=1;          //管理员
    }
}
