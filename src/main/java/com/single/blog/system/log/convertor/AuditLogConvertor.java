package com.single.blog.system.log.convertor;


import com.single.blog.base.convertor.BaseConvertor;
import com.single.blog.system.log.dto.AuditLogDTO;
import com.single.blog.system.log.model.AuditLog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AuditLogConvertor extends BaseConvertor<AuditLog, AuditLogDTO> {
    @Override
    public AuditLog toModel(AuditLogDTO auditLogDTO) {
        AuditLog model = new AuditLog();
        BeanUtils.copyProperties(auditLogDTO, model);
        return model;
    }

    @Override
    public AuditLogDTO toDTO(AuditLog auditLog) {
        AuditLogDTO dto = new AuditLogDTO();
        BeanUtils.copyProperties(auditLog, dto);
        return dto;
    }
}
