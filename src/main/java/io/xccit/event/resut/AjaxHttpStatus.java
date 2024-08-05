package io.xccit.event.resut;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>返回状态枚举</p>
 */
public enum AjaxHttpStatus {
    SUCCESS(200,"操作成功"),
    FAIL(500,"操作失败"),
    UNAUTHORIZED(401,"未授权"),
    NO_LOGIN_FAIL(401,"登录已过期"),
    FORBIDDEN(403,"禁止访问"),
    NOT_FOUND(404,"未找到"),
    SERVER_ERROR(500,"服务器错误"),
    USER_IS_NOT_EXIST(1001,"用户不存在"),
    USER_IS_EXIST(1002,"用户已存在"),
    USER_PASSWORD_ERROR(1003,"用户密码错误"),
    BAD_REQUEST(400,"请求参数错误"),
    REQUEST_PARAM_ERROR(402,"请求参数不合法"),
    OLD_PASSWORD_ERROR(1004,"旧密码错误"),
    CONFIRM_PASSWORD_ERROR(1005,"两次输入密码不一致");

    private Integer code;
    private String message;

    AjaxHttpStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
