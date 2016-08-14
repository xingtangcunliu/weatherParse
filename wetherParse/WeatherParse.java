package com.cvicse.base.common.utils;

import android.util.Xml;

import com.cvicse.base.common.data.AlarmBo;
import com.cvicse.base.common.data.DayWeather;
import com.cvicse.base.common.data.EnvironmentBo;
import com.cvicse.base.common.data.IndexBo;
import com.cvicse.base.common.data.WeatherBo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

/**
 * Created by liu_zlu on 2016/8/13 16:10
 */
class WeatherParse {

    public static WeatherBo parse(InputStream inputStream) throws XmlPullParserException, IOException {
// 由android.util.Xml创建一个XmlPullParser实例
        XmlPullParser xpp = Xml.newPullParser();

        InputStreamReader reader = getStringFromGZIP(inputStream);
        // 设置输入流 并指明编码方式
        xpp.setInput(reader);
        // 产生第一个事件
        int eventType = xpp.getEventType();
        WeatherBo weatherBo = null;
        EnvironmentBo environmentBo = null;
        AlarmBo alarmBo = null;
        ArrayList<DayWeather> forecast = null;
        DayWeather dayWeather = null;
        ArrayList<IndexBo> indexs = null;
        IndexBo indexBo = null;
        boolean isDay = true;
        while (eventType != XmlPullParser.END_DOCUMENT){
            String nodeName=xpp.getName();
            switch (eventType) {
                // 判断当前事件是否为文档开始事件
                case XmlPullParser.START_DOCUMENT:
                    weatherBo = new WeatherBo(); // 初始化books集合
                    break;
                // 判断当前事件是否为标签元素开始事件
                case XmlPullParser.START_TAG:
                    if (nodeName.equals("updatetime")) { // 判断开始标签元素是否是book
                        eventType = xpp.next();
                        weatherBo.setUpdateTime(xpp.getText());
                    } else if (nodeName.equals("wendu")) {
                        eventType = xpp.next();
                        // 得到name标签的属性值，并设置beauty的name
                        weatherBo.setTemperature(xpp.getText());
                    } else if(nodeName.equals("shidu")){
                        eventType = xpp.next();
                        weatherBo.setHumidity(xpp.getText());
                    } else if(nodeName.equals("environment")){
                        environmentBo = new EnvironmentBo();
                    } else if(nodeName.equals("quality")) {
                        eventType = xpp.next();
                        environmentBo.setQuality(xpp.getText());
                    } else if(nodeName.equals("aqi")){
                        eventType = xpp.next();
                        environmentBo.setAqi(xpp.getText());
                    } else if(nodeName.equals("pm25")){
                        eventType = xpp.next();
                        environmentBo.setPm25(xpp.getText());
                    } else if(nodeName.equals("suggest")){
                        if(alarmBo != null){
                            eventType = xpp.next();
                            alarmBo.setSuggest(xpp.getText());
                        } else {
                            eventType = xpp.next();
                            environmentBo.setSuggest(xpp.getText());
                        }
                    } else if(nodeName.equals("o3")){
                        eventType = xpp.next();
                        environmentBo.setO3(xpp.getText());
                    } else if(nodeName.equals("co")){
                        eventType = xpp.next();
                        environmentBo.setCo(xpp.getText());
                    } else if(nodeName.equals("pm10")){
                        eventType = xpp.next();
                        environmentBo.setPm10(xpp.getText());
                    } else if(nodeName.equals("so2")){
                        eventType = xpp.next();
                        environmentBo.setSo2(xpp.getText());
                    } else if(nodeName.equals("no2")){
                        eventType = xpp.next();
                        environmentBo.setNo2(xpp.getText());
                    } else if(nodeName.equals("time")){

                        eventType = xpp.next();
                        if(alarmBo != null){
                            alarmBo.setTime(xpp.getText());
                        } else {
                            environmentBo.setTime(xpp.getText());
                        }
                    }

                    else if(nodeName.equals("alarm")){
                        alarmBo = new AlarmBo();
                    } else if(nodeName.equals("cityKey")){
                        eventType = xpp.next();
                        alarmBo.setCityKey(xpp.getText());
                    } else if(nodeName.equals("cityName")){
                        eventType = xpp.next();
                        alarmBo.setCityName(xpp.getText());
                    } else if(nodeName.equals("alarmType")){
                        eventType = xpp.next();
                        alarmBo.setAlarmType(xpp.getText());
                    } else if(nodeName.equals("alarmText")){
                        eventType = xpp.next();
                        alarmBo.setAlarmText(xpp.getText());
                    } else if(nodeName.equals("alarmDegree")){
                        eventType = xpp.next();
                        alarmBo.setAlarmDegree(xpp.getText());
                    } else if(nodeName.equals("alarm_details")){
                        eventType = xpp.next();
                        alarmBo.setAlarm_details(xpp.getText());
                    } else if(nodeName.equals("standard")){
                        eventType = xpp.next();
                        alarmBo.setStandard(xpp.getText());
                    } else if(nodeName.equals("imgUrl")){
                        eventType = xpp.next();
                        alarmBo.setImgUrl(xpp.getText());
                    }


                    else if(nodeName.equals("forecast")){
                        forecast = new ArrayList<>();
                    }

                    else if(nodeName.equals("weather")){
                        dayWeather = new DayWeather();
                    } else if(nodeName.equals("date")){
                        eventType = xpp.next();
                        dayWeather.setDate(xpp.getText());
                    } else if(nodeName.equals("high")){
                        eventType = xpp.next();
                        dayWeather.setHighTemperature(xpp.getText());
                    } else if(nodeName.equals("low")){
                        eventType = xpp.next();
                        dayWeather.setLowTemperature(xpp.getText());
                    }
                    else if(nodeName.equals("day")){
                        isDay = true;
                    } else if(nodeName.equals("night")){
                        isDay = false;
                    } else if(nodeName.equals("type")){
                        eventType = xpp.next();
                        if(isDay){
                            dayWeather.setDayType(xpp.getText());
                        } else {
                            dayWeather.setNightType(xpp.getText());
                        }
                    } else if(nodeName.equals("fengxiang")){
                        eventType = xpp.next();
                        if(dayWeather != null){
                            if(isDay){
                                dayWeather.setDayWindDirection(xpp.getText());
                            } else {
                                dayWeather.setNightWindDirection(xpp.getText());
                            }
                        } else {
                            weatherBo.setWindDirection(xpp.getText());
                        }

                    } else if(nodeName.equals("fengli")){
                        eventType = xpp.next();
                        if(dayWeather != null){
                            if(isDay){
                                dayWeather.setDayWindPower(xpp.getText());
                            } else {
                                dayWeather.setNightWindPower(xpp.getText());
                            }
                        } else {
                            weatherBo.setWindPower(xpp.getText());
                        }
                    }

                    else if(nodeName.equals("zhishus")){
                        indexs = new ArrayList<>();
                    } else if(nodeName.equals("zhishu")){
                        indexBo = new IndexBo();
                    } else if(nodeName.equals("name")){
                        eventType = xpp.next();
                        indexBo.setName(xpp.getText());
                    } else if(nodeName.equals("value")){
                        eventType = xpp.next();
                        indexBo.setValue(xpp.getText());
                    } else if(nodeName.equals("detail")){
                        eventType = xpp.next();
                        indexBo.setDetail(xpp.getText());
                    }
                    //eventType = xpp.nextTag();
                    break;
                // 判断当前事件是否为标签元素结束事件
                case XmlPullParser.END_TAG:
                    if (nodeName.equals("environment")) { // 判断结束标签元素是否是book
                        environmentBo.setEnd(true);
                        weatherBo.setEnvironment(environmentBo);
                    } else if(nodeName.equals("weather")){
                        dayWeather.setEnd(true);
                        forecast.add(dayWeather);
                    }
                    else if(nodeName.equals("forecast")){
                        weatherBo.setForecast(forecast);
                    } else if(nodeName.equals("zhishu")){
                        indexs.add(indexBo);
                    } else if(nodeName.equals("zhishus")){
                        weatherBo.setIndexs(indexs);
                    }
                    // 进入下一个元素并触发相应事件
                    break;
            }
            eventType = xpp.next();

        }
        return weatherBo;
    }

    public static String inputStream2String(InputStream   is)   throws   IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int   i=-1;
        while((i=is.read())!=-1){
            baos.write(i);
        }
        return   baos.toString();
    }

    private static InputStreamReader getStringFromGZIP(InputStream is) {
        String jsonString = null;
        InputStreamReader reader = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            bis.mark(2);
            // 取前两个字节
            byte[] header = new byte[2];
            int result = bis.read(header);
            // reset输入流到开始位置
            bis.reset();
            // 判断是否是GZIP格式
            int headerData = getShort(header);
            if (result != -1 && headerData == 0x1f8b) {
                is = new GZIPInputStream(bis);
            } else {
                is = bis;
            }
             reader = new InputStreamReader(is, "utf-8");
        } catch (Exception e) {

        }
        return reader;
    }
    private static int getShort(byte[] data) {
        return (int) ((data[0] << 8) | data[1] & 0xFF);
    }
}
