package com.single.blog.system.account.repository;


import com.single.blog.system.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, RoleRepositoryCustom {
    /**
     * 根据Id查询角色
     *
     * @param roleId 角色Id
     * @return 角色
     */
    Role findFirstById(Long roleId);



}
