package com.cvicse.base.common.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.cvicse.base.common.data.WeatherBo;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liu_zlu on 2016/8/13 15:34
 */
public class WeatherUtils {

    public static void query(String city,CallBack callBack){
        new WeatherTask(callBack).execute(city);
    }


    public interface CallBack {
        public void onReturn(WeatherBo weatherBo);
    }


    static class WeatherTask extends AsyncTask<String, Integer, WeatherBo>{
        CallBack callBack;
        WeatherTask(CallBack callBack){
             this.callBack = callBack;
        }
        /**
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected WeatherBo doInBackground(String... params) {
            InputStream input = null;
            WeatherBo weather = null;
            try {
                URL url = new URL("http://wthrcdn.etouch.cn/WeatherApi?city=北京");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.connect();
                input = connection.getInputStream();
                weather =  WeatherParse.parse(input);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return weather;
        }

        @Override
        protected void onPostExecute(WeatherBo input) {
            Log.e("","");
        }
    }


}
