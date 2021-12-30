package com.single.blog.system.account.repository.impl;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.single.blog.base.bean.SearchData;
import com.single.blog.base.repository.BaseRepository;
import com.single.blog.system.account.bean.ChangePasswordBean;
import com.single.blog.system.account.model.QUser;
import com.single.blog.system.account.model.User;
import com.single.blog.system.account.repository.UserRepositoryCustom;
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
