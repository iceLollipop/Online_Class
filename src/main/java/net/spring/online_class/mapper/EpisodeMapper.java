package net.spring.online_class.mapper;

import net.spring.online_class.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {
    /**
     * 根据videoId找到当前Video的第一章集
     * @param videoId
     * @return
     */
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
