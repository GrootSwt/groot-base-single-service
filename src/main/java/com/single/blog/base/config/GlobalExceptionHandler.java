package com.single.blog.base.config;

import com.single.blog.base.exception.BusinessRuntimeException;
import com.single.blog.base.bean.result.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理器
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    /**
     * 全局异常处理器
     *
     * @param e Exception
     * @return Result.failure(异常信息)
     */
    @ExceptionHandler(value = Exception.class)
    public ResultDTO<Void> exceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof BusinessRuntimeException) {
            return ResultDTO.failure(e.getMessage());
        }
        return ResultDTO.failure("服务异常！");
    }
}

