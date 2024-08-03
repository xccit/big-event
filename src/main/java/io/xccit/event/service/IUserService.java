package io.xccit.event.service;

import io.xccit.event.entity.User;

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
}
