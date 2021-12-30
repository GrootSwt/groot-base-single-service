package com.single.blog.system.account.controller;


import com.single.blog.base.bean.result.ResultDTO;
import com.single.blog.base.util.LoginUserInfoUtil;
import com.single.blog.system.account.bean.LoginBean;
import com.single.blog.system.account.convertor.UserConvertor;
import com.single.blog.system.account.dto.UserDTO;
import com.single.blog.system.account.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录功能
 */
@Api(tags = {"登录"})
@RestController
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private UserConvertor userConvertor;

    /**
     * 登录账号密码校验，并获取用户信息、token
     *
     * @param userDTO 登录用户DTO
     * @return 用户信息、token
     */
    @ApiOperation(value = "登录")
    @PostMapping(value = "login")
    public ResultDTO<LoginBean> login(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        LoginBean bean = userService.login(userConvertor.toModel(userDTO), response);
        LoginUserInfoUtil.setOperatorInfo(userConvertor.toDTO(bean.getUserInfo()));
        return ResultDTO.success("登录成功！", bean);
    }

    @ApiOperation(value = "登出")
    @GetMapping(value = "logout")
    public ResultDTO<Void> logout() {
        userService.logout();
        return ResultDTO.success("已退出！");
    }

}
