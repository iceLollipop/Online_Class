package net.spring.online_class.service.impl;

import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoBanner;
import net.spring.online_class.mapper.VideoMapper;
import net.spring.online_class.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    // @Resource
    @Autowired
    private VideoMapper videoMapper;

    /**
     * 查询视频列表
     * @return
     */
    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }

    /**
     * 查询首页轮播图
     * @return
     */
    @Override
    public List<VideoBanner> listVideoBanner() {
        return videoMapper.listVideoBanner();
    }

    /**
     * 根据id查询视频详情
     * @return
     */
    @Override
    public Video findDetailById(int videoId) {
        Video video = videoMapper.findDetailById(videoId);
        return video;
    }
}
