package net.spring.online_class.service;

import net.spring.online_class.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    /**
     * 选课课程并下单
     * @param userId
     * @param videoId
     * @return
     */
    int saveOrder(int userId,int videoId);

    /**
     * 订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(int userId);
}
