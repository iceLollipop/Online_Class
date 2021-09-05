package net.spring.online_class.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoOrderRequest {

    // 从VideoOrderController 传参video_id 自动映射为videoId
    @JsonProperty("video_id")
    private Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
