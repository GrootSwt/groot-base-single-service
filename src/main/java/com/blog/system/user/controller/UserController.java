package com.blog.system.user.controller;


import com.blog.system.user.service.UserService;
import com.blog.base.bean.SearchData;
import com.blog.base.bean.result.ResultDTO;
import com.blog.base.bean.result.ResultPageDTO;
import com.blog.system.user.bean.ChangePasswordBean;
import com.blog.system.user.convertor.UserConvertor;
import com.blog.system.user.dto.UserDTO;
import com.blog.system.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"用户"})
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserConvertor userConvertor;

    /**
     * 分页条件查询用户信息
     *
     * @param pageable   分页条件
     * @param searchData 查询条件
     * @return 用户列表
     */
    @ApiOperation(value = "分页查询用户列表")
    @GetMapping(value = "pageableSearch")
    public ResultPageDTO<UserDTO> pageableSearch(Pageable pageable, SearchData searchData) {
        return userService.pageableSearch(pageable, searchData);
    }

    /**
     * 批量删除用户操作
     *
     * @param idArr 用户ids
     * @return 是否删除成功
     */
    @ApiOperation(value = "批量删除用户操作")
    @DeleteMapping(value = "batchDelete")
    public ResultDTO<Void> batchDelete(Long[] idArr) {
        userService.batchDelete(idArr);
        return ResultDTO.success("批量删除成功！");
    }

    @ApiOperation(value = "添加或者编辑用户（管理员修改）")
    @PostMapping(value = "addOrEditUser")
    public ResultDTO<Void> addOrEditUser(@RequestBody UserDTO userDTO) {
        userService.addOrEditUser(userConvertor.toModel(userDTO));
        return ResultDTO.success("新增或编辑用户成功！");
    }

    /**
     * 更改用户enabled
     *
     * @param userDTO 用户id和用户enabled
     * @return 更改用户enabled是否成功
     */
    @ApiOperation(value = "更改用户enabled")
    @PutMapping(value = "changeUserEnabled")
    public ResultDTO<Void> changeUserEnabled(@RequestBody UserDTO userDTO) {
        userService.changeUserEnabled(userConvertor.toModel(userDTO));
        return ResultDTO.success("更改用户启用状态成功！");
    }

    /**
     * 用户授权
     *
     * @param userDTO 用户DTO
     * @return 是否授权成功
     */
    @ApiOperation(value = "用户授权")
    @PutMapping(value = "authorization")
    public ResultDTO<Void> authorization(@RequestBody UserDTO userDTO) {
        return userService.authorization(userConvertor.toModel(userDTO));
    }

    /**
     * 更改用户信息
     *
     * @param userDTO 用户DTO
     * @return 更改后的用户信息
     */
    @ApiOperation(value = "更改用户信息（用户自己修改）")
    @PutMapping(value = "modifyUserInfo")
    public ResultDTO<UserDTO> modifyUserInfo(@RequestBody UserDTO userDTO) {
        User user = userService.modifyUserInfo(userConvertor.toModel(userDTO));
        return ResultDTO.success("更改信息成功！", userConvertor.toDTO(user));
    }


    /**
     * 更改头像
     *
     * @param userDTO 用户DTO
     * @return 更改后的用户信息
     */
    @ApiOperation(value = "更改头像")
    @PutMapping(value = "modifyAvatar")
    public ResultDTO<UserDTO> modifyAvatar(@RequestBody UserDTO userDTO) {
        User user = userService.modifyAvatar(userConvertor.toModel(userDTO));
        return ResultDTO.success("更改头像成功！", userConvertor.toDTO(user));
    }

    /**
     * 更改密码
     *
     * @param changePasswordBean 更改密码
     * @return 更改密码是否成功
     */
    @ApiOperation(value = "更改密码")
    @PutMapping(value = "changePassword")
    public ResultDTO<Void> changePassword(@RequestBody ChangePasswordBean changePasswordBean) {
        userService.changePassword(changePasswordBean);
        return ResultDTO.success("更改密码成功！");
    }
}
