package com.blog.system.user.repository;

import com.blog.system.user.model.Role;
import com.groot.base.common.SearchData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleRepositoryCustom {
    /**
     * 根据查询和分页条件获取角色列表
     *
     * @param searchData 查询条件
     * @param pageable   分页条件
     * @return 一页角色列表
     */
    Page<Role> pageableSearch(SearchData searchData, Pageable pageable);

    /**
     * 批量删除角色
     *
     * @param ids 角色id列表
     */
    void batchDeleteByIds(Long[] ids);

    /**
     * 根据角色名模糊插叙角色Id列表
     *
     * @param roleName 角色名
     * @return 角色Id列表
     */
    List<Long> findRoleIdsByRoleName(String roleName);


    /**
     * 更改角色状态
     *
     * @param toModel 角色id和角色enabled
     */
    void changeRoleEnabled(Role toModel);

}
