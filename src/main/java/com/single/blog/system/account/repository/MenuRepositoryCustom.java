package com.single.blog.system.account.repository;


import com.single.blog.base.bean.SearchData;
import com.single.blog.system.account.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuRepositoryCustom {

    /**
     * 条件分页查询菜单
     *
     * @param searchData 条件
     * @param pageable   分页条件
     * @return 分页菜单列表
     */
    Page<Menu> pageableMenu(SearchData searchData, Pageable pageable);

    /**
     * 根据id数组删除菜单列表
     *
     * @param idArr id列表
     */
    void deleteMenuByIdArr(Long[] idArr);

}
