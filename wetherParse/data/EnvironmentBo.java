package com.cvicse.base.common.data;

/**
 * 环境指数类
 * Created by liu_zlu on 2016/8/13 20:18
 */
public class EnvironmentBo {
    /**
     * 空气质量（优）
     */
    private String quality = "";
    /**
     * 空气质量指数查询（AQI)（59）
     */
    private String aqi = "";

    /**
     * pm2.5指数查询（AQI)（30）
     */
    private String pm25 = "";
    /**
     * 建议 （极少数敏感人群应减少户外活动）
     */
    private String suggest ="";
    /**
     * 二氧化硫的空气污染指数.空气污染指数(Air pollution Index,简称API)(8)
     */
    private String so2 ="";
    /**
     * 臭氧(93)
     */
    private String o3 = "";
    /**
     * 一氧化碳()
     */
    private String co = "";
    /**
     * 二氧化氮（25）
     */
    private String no2 = "";

    private String time = "";
    /**
     * 颗粒物(67)
     */
    private String pm10 = "";

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    private boolean isEnd = false;

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        if(isEnd){
            return;
        }
        this.suggest = suggest;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if(isEnd){
            return;
        }
        this.time = time;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

}
