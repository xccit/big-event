package io.xccit.event.exception;

import io.xccit.event.resut.AjaxHttpStatus;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p></p>
 */
public class OldPasswordException extends RuntimeException{

    public OldPasswordException() {
        super();
    }

    public OldPasswordException(AjaxHttpStatus status) {
        super(status.getMessage());
    }

    public OldPasswordException(String message) {
        super(message);
    }

}
