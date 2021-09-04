package net.spring.online_class.model.entity;

import java.util.Date;
// 轮播图实体类
public class VideoBanner {
    //主键
    private Integer id;

    //跳转路径
    private String url;

    //封面图
    private String img;

    //创建时间
    private Date createDate;

    //权重
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", createDate=" + createDate +
                ", weight=" + weight +
                '}';
    }
}
