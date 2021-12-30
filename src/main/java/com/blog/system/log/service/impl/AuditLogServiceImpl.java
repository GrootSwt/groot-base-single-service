package com.blog.system.log.service.impl;


import com.blog.base.bean.SearchData;
import com.blog.system.log.model.AuditLog;
import com.blog.system.log.repository.AuditLogRepository;
import com.blog.system.log.service.AuditLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Resource
    private AuditLogRepository auditLogRepository;

    @Override
    public void addLog(AuditLog auditLog) {
        auditLogRepository.save(auditLog);
    }

    @Override
    public Page<AuditLog> pageableSearch(Pageable pageable, SearchData searchData) {
        return auditLogRepository.pageableSearch(pageable, searchData);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDelete(Long[] idArr) {
        auditLogRepository.deleteAllByIdIn(Arrays.asList(idArr));
    }
}
