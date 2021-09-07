package net.spring.online_class.config;

/**
 * Guava缓存Key管理类
 */
public class CacheKeyManager {
    /**
     * 首页轮播图缓存Key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";


    /**
     * 视频列表缓存Key
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 视频详情缓存key %s是视频id
     */
    public static final String VIDEO_DETAIL = "video:detail:%s";
}
