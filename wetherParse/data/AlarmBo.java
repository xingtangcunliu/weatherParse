package com.cvicse.base.common.data;

/**
 * 预警类
 * Created by liu_zlu on 2016/8/13 20:50
 */
public class AlarmBo {

    /**
     * 10101
     */
    public String cityKey = "";
    /**
     * <![CDATA[ 北京市 ]]>
     */
    public String cityName = "";
    /**
     * 预警类型（<![CDATA[ 大风 ]]>）
     */
    public String alarmType = "";
    /**
     * 预警级别（<![CDATA[ 蓝色 ]]>）
     */
    public String alarmDegree = "";
    /**
     * 预警内容（<![CDATA[ 北京市气象台发布大风蓝色预警 ]]>）
     */
    public String alarmText = "";
    /**
     * 预警详细（<![CDATA[ 预计，3日下午到夜间，本市大部分地区将出现6级以上大风，阵风7-8级，请注意防范。 ]]>）
     */
    public String alarm_details = "";
    /**
     * 标准（<![CDATA[
     24小时内可能受大风影响,平均风力可达6级以上，或者阵风7级以上；或者已经受大风影响,平均风力为6～7级，或者阵风7～8级并可能持续。
     ]]>）
     */
    public String standard = "";
    /**
     * 建议（<![CDATA[
     1.政府及相关部门按照职责做好防大风工作；2.关好门窗，加固围板、棚架、广告牌等易被风吹动的搭建物，妥善安置易受大风影响的室外物品，遮盖建筑物资；3.相关水域水上作业和过往船舶采取积极的应对措施，如回港避风或者绕道航行等；4.行人注意尽量少骑自行车，刮风时不要在广告牌、临时搭建物等下面逗留；5.有关部门和单位注意森林、草原等防火。
     ]]>）
     */
    public String suggest = "";
    /**
     * 发布时间（2016-08-13 11:04:00）
     */
    public String time = "";
    /**
     * <![CDATA[
     http://static.etouch.cn/apps/weather/alarm_icon-1/warning_hot_yellow-1.png
     ]]>
     */
    public String imgUrl = "";

    public boolean isEnd = false;

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmDegree() {
        return alarmDegree;
    }

    public void setAlarmDegree(String alarmDegree) {
        this.alarmDegree = alarmDegree;
    }

    public String getAlarmText() {
        return alarmText;
    }

    public void setAlarmText(String alarmText) {
        this.alarmText = alarmText;
    }

    public String getAlarm_details() {
        return alarm_details;
    }

    public void setAlarm_details(String alarm_details) {
        this.alarm_details = alarm_details;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
