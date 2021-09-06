package net.spring.online_class.mapper;

import net.spring.online_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderMapper {
    /**
     * 根据user_id video_id state 查询订单状态
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findVideoOrderByCondition(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * 保存订单信息
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") int userId);
}
