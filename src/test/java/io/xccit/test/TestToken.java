package io.xccit.test;

import io.xccit.event.BigEventApplication;
import io.xccit.event.entity.User;
import io.xccit.event.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/3
 * <p></p>
 */
@SpringBootTest(classes = BigEventApplication.class)
public class TestToken {

    @Test
    public void testToken(){
        User user = new User();
        user.setId(1);
        user.setUsername("xccit");
        String token = JwtUtil.genToken(user);
        System.out.println(token);
        System.out.println(JwtUtil.verify(token));
    }
}
