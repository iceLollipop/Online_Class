package net.spring.online_class;

import io.jsonwebtoken.Claims;
import net.spring.online_class.model.entity.User;
import net.spring.online_class.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OnlineClassTestApplication {
    @Test
    public void testGeneJwt(){
        User user = new User();
        user.setId(66);
        user.setName("二当家小D");
        user.setHeadImg("png");

        String token = JWTUtils.geneJsonWebToken(user);
        System.out.println(token);

        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Claims claims = JWTUtils.checkJWT(token);
        System.out.println(claims.get("name"));

    }
}
