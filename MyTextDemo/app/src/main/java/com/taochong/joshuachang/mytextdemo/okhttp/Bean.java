package com.taochong.joshuachang.mytextdemo.okhttp;

import java.util.List;

/**
 * 常守达  2016/12/27 17:34
 * joshuachang0823@gmail.com
 */

public class Bean {

    /**
     * code : success
     * data : []
     * msg : 暂无数据
     */

    private String code;
    private String msg;
    private List<?> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
