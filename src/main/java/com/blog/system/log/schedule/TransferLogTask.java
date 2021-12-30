package com.blog.system.log.schedule;

import com.blog.system.log.model.AuditLog;
import com.blog.system.log.model.AuditLogHistory;
import com.blog.system.log.repository.AuditLogHistoryRepository;
import com.blog.system.log.repository.AuditLogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransferLogTask {

    @Resource
    private AuditLogRepository auditLogRepository;

    @Resource
    private AuditLogHistoryRepository auditLogHistoryRepository;

    /**
     * 获取日志表中所有已解决的日志转移到日志历史表中
     */
    @Scheduled(cron = "0 0 2 1 * *")
    @Transactional(rollbackFor = Exception.class)
    public void transferLog() {
        List<AuditLog> auditLogs = auditLogRepository.getAllByResolved(true);
        List<AuditLogHistory> auditLogHistories = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        auditLogs.forEach(item -> {
            AuditLogHistory history = new AuditLogHistory();
            BeanUtils.copyProperties(item, history);
            auditLogHistories.add(history);
            ids.add(history.getId());
        });
        auditLogHistoryRepository.saveAll(auditLogHistories);
        auditLogRepository.deleteAllByIdIn(ids);
    }

}
