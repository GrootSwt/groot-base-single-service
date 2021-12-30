package com.blog.system.user.repository.impl;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.blog.base.bean.SearchData;
import com.blog.base.repository.BaseRepository;
import com.blog.system.user.bean.ChangePasswordBean;
import com.blog.system.user.model.QUser;
import com.blog.system.user.model.User;
import com.blog.system.user.repository.UserRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository implements UserRepositoryCustom {

    @Override
    public Page<User> pageableSearch(Pageable pageable, SearchData searchData) {
        QUser user = QUser.user;
        BooleanBuilder where = new BooleanBuilder();
        if (searchData.hasKey("username")) {
            where.and(user.username.like("%" + searchData.getStringValue("username") + "%"));
        }
        if (searchData.hasKey("roleIds")) {
            where.and(user.roleId.in(searchData.getLongArrayValue("roleIds")));
        }
        JPAQuery<User> query = queryFactory.selectFrom(user).where(where);
        return this.search(query, pageable);
    }

    @Override
    public void changeUserEnable(User toModel) {
        QUser user = QUser.user;
        queryFactory
                .update(user)
                .set(user.enabled, toModel.getEnabled())
                .where(user.id.eq(toModel.getId()))
                .execute();
    }

    @Override
    public void changePassword(ChangePasswordBean changePasswordBean) {
        QUser user = QUser.user;
        queryFactory
                .update(user)
                .set(user.password, changePasswordBean.getNewPassword())
                .where(user.id.eq(changePasswordBean.getId()))
                .execute();
    }

    @Override
    protected Class<?> getModelClass() {
        return User.class;
    }
}
