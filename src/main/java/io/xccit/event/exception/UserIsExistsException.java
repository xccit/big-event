package io.xccit.event.exception;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>用户已存在异常</p>
 */
public class UserIsExistsException extends RuntimeException{
    public UserIsExistsException() {
        super();
    }

    public UserIsExistsException(String message) {
        super(message);
    }
}
