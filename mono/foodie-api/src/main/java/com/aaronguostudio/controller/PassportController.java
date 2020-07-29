package com.aaronguostudio.controller;

import com.aaronguostudio.pojo.bo.UserBO;
import com.aaronguostudio.service.UserService;
import com.aaronguostudio.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username) {
        if (StringUtil.isEmpty(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        if (userService.queryUsernameIsExist(username)) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }

        return IMOOCJSONResult.ok();
    }

    @PostMapping("/register")
    public IMOOCJSONResult register(@RequestBody UserBO userBO) {

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || StringUtil.isEmpty(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码不能少于 6 位");
        }

        if (!password.equals(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("密码不一致");
        }

        userService.createUser(userBO);

        return IMOOCJSONResult.ok();
    }
}
