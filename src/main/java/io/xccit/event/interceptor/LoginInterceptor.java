package io.xccit.event.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.xccit.event.constat.RedisPrefixConstat;
import io.xccit.event.entity.User;
import io.xccit.event.resut.AjaxHttpStatus;
import io.xccit.event.resut.AjaxResult;
import io.xccit.event.utils.JwtUtil;
import io.xccit.event.utils.ThreadLocalUserUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/3
 * <p>登录拦截器</p>
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization == null || authorization.equals("")){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(AjaxHttpStatus.UNAUTHORIZED.getCode());
            AjaxResult<Void> result = AjaxResult.fail(AjaxHttpStatus.UNAUTHORIZED);
            response.getWriter().write(objectMapper.writeValueAsString(result));
            return false;
        }
        String user = stringRedisTemplate.opsForValue().get(RedisPrefixConstat.USER_TOKEN_PREFIX + authorization);
        if (user != null && !user.equals("")){
            Map<String, Object> verify = JwtUtil.verify(authorization);
            ThreadLocalUserUtil.set(verify);
            return true;
        }else{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(AjaxHttpStatus.NO_LOGIN_FAIL.getCode());
            AjaxResult<Void> result = AjaxResult.fail(AjaxHttpStatus.NO_LOGIN_FAIL);
            response.getWriter().write(objectMapper.writeValueAsString(result));
        }
        return false;
        /*try {
            Map<String, Object> claims = JwtUtil.verify(authorization);
            ThreadLocalUserUtil.set(claims);
            return true;
        } catch (Exception e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(AjaxHttpStatus.UNAUTHORIZED.getCode());
            AjaxResult<Void> result = AjaxResult.fail(AjaxHttpStatus.UNAUTHORIZED);
            response.getWriter().write(objectMapper.writeValueAsString(result));
            return false;
        }*/
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUserUtil.remove();
    }
}
