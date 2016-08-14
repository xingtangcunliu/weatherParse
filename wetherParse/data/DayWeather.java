package com.cvicse.base.common.data;

/**
 * 预测类
 * Created by liu_zlu on 2016/8/13 16:48
 */
public class DayWeather {
    /**
     * 高温
     */
    private String highTemperature = "";
    /**
     * 低温
     */
    private String lowTemperature = "";
    /**
     * 白天(多云)
     */
    private String dayType = "";
    /**
     * 晚上(多云)
     */
    private String nightType = "";
    /**
     * 白天(东南风)
     */
    private String dayWindDirection = "";
    /**
     * 晚上(东南风)
     */
    private String nightWindDirection = "";
    /**
     * 白天(3-4级)
     */
    private String dayWindPower = "";
    /**
     * 晚上(3-4级)
     */
    private String nightWindPower = "";

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date = "";
    private boolean isEnd = false;

    public String getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(String highTemperature) {
        this.highTemperature = highTemperature;
    }

    public String getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(String lowTemperature) {
        this.lowTemperature = lowTemperature;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public String getNightType() {
        return nightType;
    }

    public void setNightType(String nightType) {
        this.nightType = nightType;
    }

    public String getDayWindDirection() {
        return dayWindDirection;
    }

    public void setDayWindDirection(String dayWindDirection) {
        this.dayWindDirection = dayWindDirection;
    }

    public String getNightWindDirection() {
        return nightWindDirection;
    }

    public void setNightWindDirection(String nightWindDirection) {
        this.nightWindDirection = nightWindDirection;
    }

    public String getDayWindPower() {
        return dayWindPower;
    }

    public void setDayWindPower(String dayWindPower) {
        this.dayWindPower = dayWindPower;
    }

    public String getNightWindPower() {
        return nightWindPower;
    }

    public void setNightWindPower(String nightWindPower) {
        this.nightWindPower = nightWindPower;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
