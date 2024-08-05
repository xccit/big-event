package io.xccit.event.entity.dto;

import jakarta.validation.constraints.Pattern;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>用户密码修改参数接收</p>
 */
public class UserPasswordDTO {

    /**旧密码*/
    @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$",message = "密码格式不正确")
    private String oldPwd;
    /**新密码*/
    @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$",message = "密码格式不正确")
    private String newPwd;
    /**确认密码*/
    @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$",message = "密码格式不正确")
    private String rePwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getRePwd() {
        return rePwd;
    }

    public void setRePwd(String rePwd) {
        this.rePwd = rePwd;
    }

    @Override
    public String toString() {
        return "UserPasswordDTO{" +
                "oldPwd='" + oldPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                ", rePwd='" + rePwd + '\'' +
                '}';
    }
}
