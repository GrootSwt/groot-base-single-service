package com.blog.system.log.convertor;


import com.blog.system.log.dto.AuditLogDTO;
import com.blog.system.log.model.AuditLog;
import com.groot.base.web.convertor.BaseConvertor;
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
