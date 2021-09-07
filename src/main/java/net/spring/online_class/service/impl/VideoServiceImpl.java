package net.spring.online_class.service.impl;

import net.spring.online_class.config.CacheKeyManager;
import net.spring.online_class.model.entity.Video;
import net.spring.online_class.model.entity.VideoBanner;
import net.spring.online_class.mapper.VideoMapper;
import net.spring.online_class.service.VideoService;
import net.spring.online_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    // @Resource
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    /**
     * 查询视频列表
     * @return
     */
    @Override
    public List<Video> listVideo() {
        try{
            Object cacheObj =  baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST,()->{
                List<Video> videoList = videoMapper.listVideo();
                System.out.println("从数据库里面找视频列表");
                return  videoList;
            });
            // 从缓存获取到值
            if(cacheObj instanceof List){
                List<Video> videoList = (List<Video>)cacheObj;
                return videoList;
            }
        }catch (Exception e){

        }
        // 缓存无值&mapper无值 return null
        return null;
    }

    /**
     * 查询首页轮播图
     * @return
     */
    @Override
    public List<VideoBanner> listVideoBanner() {
        try{
            Object cacheObj =  baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY,()->{
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                System.out.println("从数据库里面找轮播图列表");
                return  bannerList;
            });
            // 从缓存获取到值
            if(cacheObj instanceof List){
                List<VideoBanner> bannerList = (List<VideoBanner>)cacheObj;
                return bannerList;
            }
        }catch (Exception e){

        }
        // 缓存无值&mapper无值 return null
        return null;
    }

    /**
     * 根据id查询视频详情
     * @return
     */
    @Override
    public Video findDetailById(int videoId) {
        // Video video = videoMapper.findDetailById(videoId);
        // return video;
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);
        try{
            Object cacheObject = baseCache.getOneHourCache().get( videoCacheKey, ()->{
                // 需要使用mybaits关联复杂查询
                Video video = videoMapper.findDetailById(videoId);
                System.out.println("从数据库里面找视频详情");
                return video;

            });
            if(cacheObject instanceof Video){
                Video video = (Video)cacheObject;
                return video;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // 缓存无值&mapper无值 return null
        return null;
    }
}
