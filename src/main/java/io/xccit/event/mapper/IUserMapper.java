package io.xccit.event.mapper;

import io.xccit.event.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 修改用户信息
     * @param user 用户
     */
    void update(User user);

    /**
     * 修改用户头像
     * @param avatarUrl
     */
    @Update("UPDATE user SET user_pic = #{avatarUrl},update_time = now() WHERE id = #{id}")
    void updateAvatar(String avatarUrl,Integer id);

    /**
     * 修改用户密码
     * @param password
     */
    @Update("UPDATE user SET password = #{password},update_time = now() WHERE id = #{id}")
    void updatePassword(@Param("password") String password, Integer id);
}
