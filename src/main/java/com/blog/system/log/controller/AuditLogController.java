package com.blog.system.log.controller;

import com.blog.base.bean.SearchData;
import com.blog.base.bean.result.ResultDTO;
import com.blog.base.bean.result.ResultPageDTO;
import com.blog.system.log.convertor.AuditLogConvertor;
import com.blog.system.log.dto.AuditLogDTO;
import com.blog.system.log.model.AuditLog;
import com.blog.system.log.service.AuditLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"日志审计"})
@RestController
@RequestMapping(value = "auditLog")
public class AuditLogController {

    @Resource
    private AuditLogService auditLogService;

    @Resource
    private AuditLogConvertor auditLogConvertor;

    @ApiOperation(value = "日志新增")
    @PostMapping(value = "addLog")
    public void addLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLog auditLog = auditLogConvertor.toModel(auditLogDTO);
        auditLogService.addLog(auditLog);
    }

    @ApiOperation(value = "日志分页条件查询")
    @GetMapping(value = "pageableSearch")
    public ResultPageDTO<AuditLogDTO> pageableSearch(Pageable pageable, SearchData searchData) {
        Page<AuditLog> auditLogs = auditLogService.pageableSearch(pageable, searchData);
        Page<AuditLogDTO> auditLogDTOS = auditLogConvertor.toPageDTO(auditLogs);
        return ResultPageDTO.success("获取日志成功！", auditLogDTOS);
    }

    @ApiOperation(value = "日志批量删除")
    @DeleteMapping(value = "batchDelete")
    public ResultDTO<Void> batchDelete(@RequestParam Long[] idArr) {
        auditLogService.batchDelete(idArr);
        return ResultDTO.success("日志批量删除成功！");
    }
}
