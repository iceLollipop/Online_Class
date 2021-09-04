package net.spring.online_class.mapper;

import net.spring.online_class.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 注册用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据手机号查找用户
     * @param phone
     * @return
     */
    User findUserByPhone(@Param("phone") String phone);


    /**
     * 根据手机号和密码查找用户
     * @param phone
     * @param pwd
     * @return
     */
    User findUserByPhoneAndPwd(@Param("phone") String phone,@Param("pwd") String pwd);
}
