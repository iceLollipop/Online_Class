package net.spring.online_class.controller;

import net.spring.online_class.model.entity.User;
import net.spring.online_class.model.request.LoginRequest;
import net.spring.online_class.service.UserService;
import net.spring.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
        int rows = userService.save(userInfo);
        return rows == 1?JsonData.buildSuccess():JsonData.buildError("注册失败，请重试");
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findUserByPhoneAndPwd(loginRequest.getPhone(),loginRequest.getPwd());
        return token == null?JsonData.buildError("登录失败，账号密码错误"):JsonData.buildSuccess(token);
    }

    @GetMapping("find_by_token")
    public JsonData findUserByToken(HttpServletRequest httpServletRequest){
        Integer userId = (Integer) httpServletRequest.getAttribute("user_id");

        if(userId == null){     //token不合法
            return JsonData.buildError("查询失败");
        }

        User user = userService.findUserById(userId);
        return JsonData.buildSuccess(user);
    }
}
