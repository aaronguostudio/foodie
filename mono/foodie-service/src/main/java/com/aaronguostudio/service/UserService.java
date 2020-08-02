package com.aaronguostudio.service;

import com.aaronguostudio.pojo.Users;
import com.aaronguostudio.pojo.bo.UserBO;

public interface UserService {

    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     */
    public Users queryUserForLogin(String username, String password);
}
