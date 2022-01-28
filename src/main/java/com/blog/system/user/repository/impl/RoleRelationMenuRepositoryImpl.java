package com.blog.system.user.repository.impl;


import com.blog.system.user.model.QRoleRelationMenu;
import com.blog.system.user.model.RoleRelationMenu;
import com.blog.system.user.repository.RoleRelationMenuRepositoryCustom;
import com.groot.base.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRelationMenuRepositoryImpl extends BaseRepository implements RoleRelationMenuRepositoryCustom {
    @Override
    public List<Long> getMenuIdsByRoleId(Long roleId) {
        QRoleRelationMenu roleRelationMenu = QRoleRelationMenu.roleRelationMenu;
        return queryFactory
                .select(roleRelationMenu.menuId)
                .from(roleRelationMenu)
                .where(roleRelationMenu.roleId.eq(roleId))
                .fetch();
    }

    @Override
    protected Class<?> getModelClass() {
        return RoleRelationMenu.class;
    }
}
