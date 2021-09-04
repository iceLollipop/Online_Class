package net.spring.online_class.service;

import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoService {
    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 查询首页轮播图
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 根据id查询视频详情
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);
}
