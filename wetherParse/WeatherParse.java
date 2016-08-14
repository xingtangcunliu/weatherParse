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
                        weatherBo.setUpdateTime(xpp.nextText());
                    } else if (nodeName.equals("wendu")) {
                        // 得到name标签的属性值，并设置beauty的name
                        weatherBo.setTemperature(xpp.nextText());
                    } else if(nodeName.equals("shidu")){
                        weatherBo.setHumidity(xpp.nextText());
                    } else if(nodeName.equals("environment")){
                        environmentBo = new EnvironmentBo();
                    } else if(nodeName.equals("quality")) {
                        environmentBo.setQuality(xpp.nextText());
                    } else if(nodeName.equals("aqi")){
                        environmentBo.setAqi(xpp.nextText());
                    } else if(nodeName.equals("pm25")){
                        environmentBo.setPm25(xpp.nextText());
                    } else if(nodeName.equals("suggest")){
                        environmentBo.setSuggest(xpp.nextText());

                        if(alarmBo != null){
                            alarmBo.setSuggest(xpp.nextText());
                        }
                    } else if(nodeName.equals("o3")){
                        environmentBo.setO3(xpp.nextText());
                    } else if(nodeName.equals("co")){
                        environmentBo.setCo(xpp.nextText());
                    } else if(nodeName.equals("pm10")){
                        environmentBo.setPm10(xpp.nextText());
                    } else if(nodeName.equals("so2")){
                        environmentBo.setSo2(xpp.nextText());
                    } else if(nodeName.equals("no2")){
                        environmentBo.setNo2(xpp.nextText());
                    } else if(nodeName.equals("time")){
                        environmentBo.setTime(xpp.nextText());

                        if(alarmBo != null){
                            alarmBo.setTime(xpp.nextText());
                        }
                    }

                    else if(nodeName.equals("alarm")){
                        alarmBo = new AlarmBo();
                    } else if(nodeName.equals("cityKey")){
                        alarmBo.setCityKey(xpp.nextText());
                    } else if(nodeName.equals("cityName")){
                        alarmBo.setCityName(xpp.nextText());
                    } else if(nodeName.equals("alarmType")){
                        alarmBo.setAlarmType(xpp.nextText());
                    } else if(nodeName.equals("alarmText")){
                        alarmBo.setAlarmText(xpp.nextText());
                    } else if(nodeName.equals("alarmDegree")){
                        alarmBo.setAlarmDegree(xpp.nextText());
                    } else if(nodeName.equals("alarm_details")){
                        alarmBo.setAlarm_details(xpp.nextText());
                    } else if(nodeName.equals("standard")){
                        alarmBo.setStandard(xpp.nextText());
                    } else if(nodeName.equals("imgUrl")){
                        alarmBo.setImgUrl(xpp.nextText());
                    }


                    else if(nodeName.equals("forecast")){
                        forecast = new ArrayList<>();
                    }

                    else if(nodeName.equals("weather")){
                        dayWeather = new DayWeather();
                    } else if(nodeName.equals("date")){
                        dayWeather.setDate(xpp.nextText());
                    } else if(nodeName.equals("high")){
                        dayWeather.setHighTemperature(xpp.nextText());
                    } else if(nodeName.equals("low")){
                        dayWeather.setLowTemperature(xpp.nextText());
                    }
                    else if(nodeName.equals("day")){
                        isDay = true;
                    } else if(nodeName.equals("night")){
                        isDay = false;
                    } else if(nodeName.equals("type")){
                        if(isDay){
                            dayWeather.setDayType(xpp.nextText());
                        } else {
                            dayWeather.setNightType(xpp.nextText());
                        }
                    } else if(nodeName.equals("fengxiang")){
                        if(dayWeather != null){
                            if(isDay){
                                dayWeather.setDayWindDirection(xpp.nextText());
                            } else {
                                dayWeather.setNightWindDirection(xpp.nextText());
                            }
                        } else {
                            weatherBo.setWindDirection(xpp.nextText());
                        }

                    } else if(nodeName.equals("fengli")){
                        if(dayWeather != null){
                            if(isDay){
                                dayWeather.setDayWindPower(xpp.nextText());
                            } else {
                                dayWeather.setNightWindPower(xpp.nextText());
                            }
                        } else {
                            weatherBo.setWindPower(xpp.nextText());
                        }
                    }

                    else if(nodeName.equals("zhishus")){
                        indexs = new ArrayList<>();
                    } else if(nodeName.equals("zhishu")){
                        indexBo = new IndexBo();
                    } else if(nodeName.equals("name")){
                        indexBo.setName(xpp.nextText());
                    } else if(nodeName.equals("value")){
                        indexBo.setValue(xpp.nextText());
                    } else if(nodeName.equals("detail")){
                        indexBo.setDetail(xpp.nextText());
                    }
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
                    break;
            }
            // 进入下一个元素并触发相应事件
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
