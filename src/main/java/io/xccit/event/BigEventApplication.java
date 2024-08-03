package io.xccit.event;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>启动类</p>
 */
@SpringBootApplication
@MapperScan(basePackages = "io.xccit.event.mapper")
public class BigEventApplication {
    public static void main(String[] args) {
        SpringApplication.run(BigEventApplication.class, args);
        System.out.println("大事件后台启动成功☺");
    }
}
