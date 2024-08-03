package io.xccit.event.mapper;

import io.xccit.event.entity.User;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>用户mapper</p>
 */
public interface IUserMapper {
    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    User selectByUsername(String username);

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);
}
