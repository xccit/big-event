package io.xccit.event.exception;

import io.xccit.event.resut.AjaxHttpStatus;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/3
 * <p>用户登录异常</p>
 */
public class UserLoginException extends RuntimeException{
    public UserLoginException(){}
    public UserLoginException(String message){
        super(message);
    }
    public UserLoginException(AjaxHttpStatus ajaxHttpStatus){
        super(ajaxHttpStatus.getMessage());
    }
}
