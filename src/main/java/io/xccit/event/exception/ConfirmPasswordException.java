package io.xccit.event.exception;

import io.xccit.event.resut.AjaxHttpStatus;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>两次密码不一致</p>
 */
public class ConfirmPasswordException extends RuntimeException{
    public ConfirmPasswordException(){}
    public ConfirmPasswordException(String message) {
        super(message);
    }
    public ConfirmPasswordException(AjaxHttpStatus status) {
        super(status.getMessage());
    }
}
