package net.spring.online_class.service.impl;

import net.spring.online_class.mapper.VideoMapper;
import net.spring.online_class.mapper.VideoOrderMapper;
import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoOrder;
import net.spring.online_class.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;
    /**
     * 选课课程并下单
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int saveOrder(int userId, int videoId) {
        // 下单前查询当前课程是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findVideoOrderByCondition(userId,videoId,1);
        if(videoOrder != null){     // 已经购买
            return 0;
        }
        Video video = videoMapper.findById(videoId);
        VideoOrder newVideoOrder = new VideoOrder();

        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoTitle(video.getTitle());
        newVideoOrder.setVideoImg(video.getCoverImg());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);
        return rows;
    }
}
