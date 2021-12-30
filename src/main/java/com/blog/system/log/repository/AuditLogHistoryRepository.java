package com.blog.system.log.repository;

import com.blog.system.log.model.AuditLogHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogHistoryRepository extends JpaRepository<AuditLogHistory, Long> {
}
