package net.spring.online_class.mapper;

import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoBanner;

import java.util.List;

public interface VideoMapper {
    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     *查询轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     *根据id查询视频详情
     * @return
     */
    Video findDetailById(int videoId);
}
