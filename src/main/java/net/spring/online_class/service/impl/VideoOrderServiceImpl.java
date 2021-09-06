package net.spring.online_class.service.impl;

import net.spring.online_class.exception.CustomException;
import net.spring.online_class.mapper.EpisodeMapper;
import net.spring.online_class.mapper.PlayRecordMapper;
import net.spring.online_class.mapper.VideoMapper;
import net.spring.online_class.mapper.VideoOrderMapper;
import net.spring.online_class.model.entity.Episode;
import net.spring.online_class.model.entity.PlayRecord;
import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoOrder;
import net.spring.online_class.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired      //获取章节信息
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;
    /**
     * 选课课程并下单
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
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
        if(rows==1) {     // 下单成功 生成播放记录表
            // 获取Video的章集信息
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if(episode==null){
                throw new CustomException(-1,"视频没有章集信息,请运营人员检查");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);

            // 根据章集信息,设置播放记录
            playRecordMapper.saveRecord(playRecord);
        }
        return rows;
    }
}
