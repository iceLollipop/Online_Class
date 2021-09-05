package net.spring.online_class.mapper;

import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

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
     *根据id查询视频详情 会关联视频课程章集
     * @return
     */
    Video findDetailById(@Param("video_id")int videoId);

    /**
     * 根据id查询视频详情 不关联其他对象属性
     * @param videoId
     * @return
     */
    Video findById(@Param("video_id")int videoId);
}
