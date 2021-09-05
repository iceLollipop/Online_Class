package net.spring.online_class.controller;

import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoBanner;
import net.spring.online_class.service.VideoService;
import net.spring.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 首页轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner(){
        List<VideoBanner> videoBanners = videoService.listVideoBanner();
        return JsonData.buildSuccess(videoBanners);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public Object listVideo(){
        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }


    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true) int videoId){
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
