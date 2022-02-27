package com.blog.system.user.service;


import com.blog.system.user.model.Role;
import com.groot.base.common.SearchData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    /**
     * 根据角色Id查询角色
     *
     * @param roleId 角色Id
     * @return 角色
     */
    Role findFirstById(String roleId);

    /**
     * 根据查询和分页条件获取角色列表
     *
     * @param searchData 查询条件
     * @param pageable   分页条件
     * @return 一页角色列表
     */
    Page<Role> pageableSearch(SearchData searchData, Pageable pageable);

    /**
     * 根据角色Id获取菜单Ids列表
     *
     * @param id 角色Id
     * @return 菜单列表Id
     */
    List<String> getMenuIdArrByRoleId(String id);

    /**
     * 角色分配权限
     *
     * @param roleId     角色Id
     * @param allMenuIds 菜单Id列表
     */
    void assignPermissions(String roleId, List<String> allMenuIds);

    /**
     * 保存角色
     *
     * @param toModel 角色
     */
    void saveRole(Role toModel, String[] menuIdArr);

    /**
     * 批量删除角色
     *
     * @param ids 角色id列表
     */
    void batchDeleteByIds(String[] ids);

    /**
     * 获取全部启用角色
     *
     * @return 全部启用角色
     */
    List<Role> getAllRoleList();

    /**
     * 更改角色状态
     *
     * @param toModel 角色id和角色enabled
     */
    void changeRoleEnabled(Role toModel);

    /**
     * 获取新增角色名是否存在
     *
     * @param roleName 角色名
     * @return 角色名是否存在
     */
    Boolean roleNameIsExist(String roleName);
}
