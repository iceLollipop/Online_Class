package net.spring.online_class.service;

public interface VideoOrderService {
    /**
     * 选课课程并下单
     * @param userId
     * @param videoId
     * @return
     */
    int saveOrder(int userId,int videoId);
}
