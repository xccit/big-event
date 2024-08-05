package io.xccit.event.service;

import io.xccit.event.entity.User;
import io.xccit.event.entity.dto.UserPasswordDTO;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>用户Service</p>
 */
public interface IUserService {
    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return <p>返回token</p>
     */
    String login(String username, String password);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    User selectInfo(String username);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 修改用户头像
     * @param avatarUrl
     */
    void updateAvatar(String avatarUrl);

    /**
     * 修改用户密码
     * @param userPasswordDTO
     */
    void updatePassword(UserPasswordDTO userPasswordDTO,HttpServletRequest request);

    /**
     * 用户退出
     * @param request
     */
    void logout(HttpServletRequest request);
}
