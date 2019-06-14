package com.qzsq.article.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author ffc
 * @Description //TODO 响应消息
 * @Date 2019/5/6
 * @Param * @param null
 * @return
 **/
public class ResponseCode implements Serializable {
    private int code;
    private String msg;
    private Map<Object, Object> date = new HashMap<>();
    //
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount( int count ) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode( int code ) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }

    public Map<Object, Object> getDate() {
        return date;
    }

    public void setDate( Map<Object, Object> date ) {
        this.date = date;
    }

    public ResponseCode( int code, String msg ) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseCode( int code, String msg, Map<Object, Object> date ) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public ResponseCode() {
    }

    public ResponseCode( int code, String msg, Map<Object, Object> date, int count ) {
        this.code = code;
        this.msg = msg;
        this.date = date;
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", msg='" + msg + '/' +
                ", date=" + date +
                ", count=" + count +
                '}';
    }

    public static ResponseCode OK() {
        return new ResponseCode(200, "ok");
    }


    public static ResponseCode UNKNOWNERROR() {
        return new ResponseCode(220, "未知错误");
    }

}
