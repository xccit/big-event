package io.xccit.event.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.xccit.event.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/3
 * <p>JWT工具类</p>
 */
public class JwtUtil {

    private static final String SECRET = "xccit";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String genToken(User user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        return JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Map<String, Object> verify(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        Map<String, Object> user = verify.getClaim("user").asMap();
        return user;
    }
}
