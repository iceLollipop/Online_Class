package net.spring.online_class.service.impl;

import net.spring.online_class.model.entity.User;
import net.spring.online_class.mapper.UserMapper;
import net.spring.online_class.service.UserService;
import net.spring.online_class.utils.CommonUtils;
import net.spring.online_class.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceimpl implements UserService {
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if(user != null){
            return userMapper.save(user);
        }else{
            return -1;
        }
    }

    /**
     * 根据手机号和密码查找用户
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public String findUserByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findUserByPhoneAndPwd(phone,CommonUtils.MD5(pwd));
        if(user == null){
            return null;
        }else{
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }

    /**
     * 根据token中保存的id信息 查询User对象
     * @param userId
     * @return
     */
    @Override
    public User findUserById(Integer userId) {
        User user = userMapper.findUserById(userId);
        return user;
    }

    /**
     * 接收Post方法的userInfo信息 格式为json，转化为User对象
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String,String> userInfo){
        if(userInfo.containsKey("phone")&&userInfo.containsKey("pwd")&&userInfo.containsKey("name")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            // MD5加密
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        }
        else
            return null;
    }


    private String getRandomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index  =  random.nextInt(size);
        return headImg[index];
    }


}
