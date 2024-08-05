package io.xccit.event.exception;

import io.xccit.event.resut.AjaxHttpStatus;
import io.xccit.event.resut.AjaxResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AjaxResult handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<ConstraintViolation<?>> list = constraintViolations.stream().toList();
        System.out.println(list);
        return AjaxResult.fail(AjaxHttpStatus.REQUEST_PARAM_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AjaxResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return AjaxResult.fail(AjaxHttpStatus.REQUEST_PARAM_ERROR);
    }

    @ExceptionHandler(OldPasswordException.class)
    public AjaxResult handleOldPasswordException(OldPasswordException e) {
        return AjaxResult.fail(AjaxHttpStatus.OLD_PASSWORD_ERROR);
    }

    @ExceptionHandler(ConfirmPasswordException.class)
    public AjaxResult handleConfirmPasswordException(ConfirmPasswordException e) {
        return AjaxResult.fail(AjaxHttpStatus.CONFIRM_PASSWORD_ERROR);
    }
}
