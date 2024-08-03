package io.xccit.event.controller;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.xccit.event.entity.User;
import io.xccit.event.resut.AjaxHttpStatus;
import io.xccit.event.resut.AjaxResult;
import io.xccit.event.service.IUserService;
import io.xccit.event.utils.JwtUtil;
import io.xccit.event.utils.ThreadLocalUserUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>用户控制器</p>
 */
@Tag(name = "用户信息")
@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/register")
    @Operation(summary = "用户注册")
    @Parameters({
            @Parameter(name = "username",description = "用户名",required = true),
            @Parameter(name = "password",description = "密码",required = true)
    })
    public AjaxResult register(@Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$",message = "用户名格式不正确") String username,
                               @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$",message = "密码格式不正确") String password){
        userService.register(username,password);
        return AjaxResult.success("注册成功");
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Operation(summary = "用户登录")
    @Parameters({
            @Parameter(name = "username",description = "用户名",required = true),
            @Parameter(name = "password",description = "密码",required = true)
    })
    @PostMapping(value = "/login")
    public AjaxResult login(@Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$",message = "用户名格式不正确") String username,
                            @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$",message = "密码格式不正确") String password){
        String token = userService.login(username, password);
        return AjaxResult.success(AjaxHttpStatus.SUCCESS,token);
    }

    /**
     * 用户信息
     * @return
     */
    @Operation(summary = "用户信息")
    @GetMapping(value = "/info")
    public AjaxResult info(){
        Map<String, Object> userMap = ThreadLocalUserUtil.get();
        String username = (String) userMap.get("username");
        User user = userService.selectInfo(username);
        return AjaxResult.success(AjaxHttpStatus.SUCCESS,user);
    }
}
