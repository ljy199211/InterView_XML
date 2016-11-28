package com.example.administrator.result;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

//"city": "suzhou",
//        "AQI": "77",
//        "quality": "良",
//        "date": "2014-05-09 14:00"

public class citynowResult {

    private String city;
    private String AQI;
    private String quality;
    private String date;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
