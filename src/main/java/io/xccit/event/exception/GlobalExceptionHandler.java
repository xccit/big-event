package io.xccit.event.exception;

import io.xccit.event.resut.AjaxResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>全局异常捕获</p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public AjaxResult<Object> handleException(Exception e) {
        e.printStackTrace();
        return AjaxResult.fail(e.getMessage());
    }

    @ExceptionHandler(UserIsExistsException.class)
    public AjaxResult<Object> handleUserIsExistsException(UserIsExistsException e) {
        e.printStackTrace();
        return AjaxResult.fail(e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    public AjaxResult<Object> handleUserLoginException(UserLoginException e) {
        e.printStackTrace();
        return AjaxResult.fail(e.getMessage());
    }
}
