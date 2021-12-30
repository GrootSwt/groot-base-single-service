package com.single.blog.system.log.repository;

import com.single.blog.system.log.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>, AuditLogRepositoryCustom {

    void deleteAllByIdIn(Collection<Long> id);
}
