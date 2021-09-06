package net.spring.online_class;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("net.spring.online_class.mapper")
@EnableTransactionManagement        //EnableTransactionManagement 开启事务控制,需要配合业务类or业务方法开启Transactional
public class OnlineClassApplication {
    public static void main(String[] args) {
        System.out.println("SpringBoot 启动成功");
        SpringApplication.run(OnlineClassApplication.class,args);
    }
}
