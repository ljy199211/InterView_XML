package com.example.administrator.result;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class SearchResult {
//    {
//        "resultcode": "200",
//            "reason": "SUCCESSED!",
//            "error_code": 0,
//            "result": [

    private String resultcode;
    private String reason;
    private int error_code;
    private List<ResultResult> result;

    //Alt+insert


    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
