package com.single.blog.system.log.repository;

import com.single.blog.system.log.model.AuditLogHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogHistoryRepository extends JpaRepository<AuditLogHistory, Long> {
}
