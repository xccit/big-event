package io.xccit.event.service.impl;

import com.auth0.jwt.JWT;
import io.xccit.event.entity.User;
import io.xccit.event.entity.dto.UserPasswordDTO;
import io.xccit.event.exception.ConfirmPasswordException;
import io.xccit.event.exception.OldPasswordException;
import io.xccit.event.exception.UserIsExistsException;
import io.xccit.event.exception.UserLoginException;
import io.xccit.event.mapper.IUserMapper;
import io.xccit.event.resut.AjaxHttpStatus;
import io.xccit.event.service.IUserService;
import io.xccit.event.utils.JwtUtil;
import io.xccit.event.utils.MD5Util;
import io.xccit.event.utils.ThreadLocalUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>用户Service</p>
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void register(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user != null) {
            throw new UserIsExistsException("用户已存在");
        }else{
            // 密码加密
            String md5Password = MD5Util.getMD5String(password);
            userMapper.register(username, md5Password);
        }
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public String login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new UserLoginException(AjaxHttpStatus.USER_IS_NOT_EXIST);
        }
        if (!user.getPassword().equals(MD5Util.getMD5String(password))) {
            throw new UserLoginException(AjaxHttpStatus.USER_PASSWORD_ERROR);
        }
        return JwtUtil.genToken(user);
    }

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User selectInfo(String username) {
        return userMapper.selectByUsername(username);
    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    /**
     * 修改用户头像
     *
     * @param avatarUrl
     */
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> user = ThreadLocalUserUtil.get();
        Integer id = (Integer) user.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    /**
     * 修改用户密码
     *
     * @param userPasswordDTO
     */
    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        String oldPwd = userPasswordDTO.getOldPwd();
        String newPwd = userPasswordDTO.getNewPwd();
        String rePwd = userPasswordDTO.getRePwd();
        Map<String,Object> user = ThreadLocalUserUtil.get();
        String username = (String) user.get("username");
        User selectedUser = userMapper.selectByUsername(username);
        if (selectedUser == null){
            throw new UserIsExistsException(AjaxHttpStatus.SERVER_ERROR);
        }
        if (!selectedUser.getPassword().equals(MD5Util.getMD5String(oldPwd))) {
            throw new OldPasswordException(AjaxHttpStatus.OLD_PASSWORD_ERROR);
        }
        if (!newPwd.equals(rePwd)) {
            throw new ConfirmPasswordException(AjaxHttpStatus.CONFIRM_PASSWORD_ERROR);
        }
        userMapper.updatePassword(MD5Util.getMD5String(newPwd),selectedUser.getId());
    }
}
