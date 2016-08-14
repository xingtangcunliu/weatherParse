package com.cvicse.base.common.data;

import java.util.ArrayList;

/**
 * 天气类
 * Created by liu_zlu on 2016/8/13 15:41
 */
public class WeatherBo {

    /**
     * 更新时间
     */
    private String updateTime = "";
    /**
     * 温度
     */
    private String temperature = "";
    /**
     * 风力
     */
    private String windPower = "";
    /**
     * 湿度
     */
    private String humidity = "";
    /**
     * 风向
     */
    private String windDirection = "";

    /**
     * 环境指数
     */
    private EnvironmentBo environment ;
    /**
     * 预警信息（可能没有该信息）
     */
    private AlarmBo alarm ;
    /**
     * 预测（包括当天以及以后的的五天天气信息）
     */
    private ArrayList<DayWeather> forecast;
    /**
     * 健康指数
     */
    private ArrayList<IndexBo> indexs;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public EnvironmentBo getEnvironment() {
        return environment;
    }

    public void setEnvironment(EnvironmentBo environment) {
        this.environment = environment;
    }

    public AlarmBo getAlarm() {
        return alarm;
    }

    public void setAlarm(AlarmBo alarm) {
        this.alarm = alarm;
    }

    public ArrayList<DayWeather> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<DayWeather> forecast) {
        this.forecast = forecast;
    }

    public ArrayList<IndexBo> getIndexs() {
        return indexs;
    }

    public void setIndexs(ArrayList<IndexBo> indexs) {
        this.indexs = indexs;
    }
}
