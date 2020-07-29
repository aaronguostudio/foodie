package com.aaronguostudio.service;

import com.aaronguostudio.pojo.Users;
import com.aaronguostudio.pojo.bo.UserBO;

public interface UserService {

    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);
}
