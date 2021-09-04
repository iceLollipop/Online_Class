package net.spring.online_class;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.spring.online_class.mapper")
public class OnlineClassApplication {
    public static void main(String[] args) {
        System.out.println("SpringBoot 启动成功");
        SpringApplication.run(OnlineClassApplication.class,args);
    }
}
