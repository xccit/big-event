package io.xccit.event.config;

import io.xccit.event.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/3
 * <p>web配置</p>
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/register",
                        "/user/login",
                        "/webjars/**",
                        "/v3/api-docs/**",
                        "favicon.ico",
                        "/doc.html");
    }
}
