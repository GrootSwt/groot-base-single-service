package com.groot.base.system.log.repository;

import com.groot.base.system.log.model.AuditLogHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogHistoryRepository extends JpaRepository<AuditLogHistory, String> {
}
