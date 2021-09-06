package net.spring.online_class.mapper;

import net.spring.online_class.model.entity.Episode;
import net.spring.online_class.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {
    /**
     * 保存播放记录
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord);
}
