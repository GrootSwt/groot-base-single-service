package com.single.blog.system.log.repository;


import com.single.blog.base.bean.SearchData;
import com.single.blog.system.log.model.AuditLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditLogRepositoryCustom {

    /**
     * 条件分页查询日志
     *
     * @param pageable   分页
     * @param searchData 查询条件
     * @return 符合条件的分页日志
     */
    Page<AuditLog> pageableSearch(Pageable pageable, SearchData searchData);
}
