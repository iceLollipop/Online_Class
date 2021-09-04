package net.spring.online_class.service;

import net.spring.online_class.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    int save(Map<String,String> userInfo);

    /**
     * 根据手机号查找用户
     * @param phone
     * @return
     */
    // User findUserByPhone(String phone);

    /**
     * 根据手机号和密码查找用户
     * @param phone
     * @param pwd
     * @return
     */
    String findUserByPhoneAndPwd(String phone, String pwd);
}
