package com.single.blog.system.account.repository.impl;


import com.single.blog.base.repository.BaseRepository;
import com.single.blog.system.account.model.QRoleRelationMenu;
import com.single.blog.system.account.model.RoleRelationMenu;
import com.single.blog.system.account.repository.RoleRelationMenuRepositoryCustom;
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
