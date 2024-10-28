package com.example.common;

public class Result {

    private static final String success="0";
    private static final String error="-1";
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(){
      Result result=new Result();
      result.setCode(success);
      return result;
    }

    public static Result success(Object data){
        Result result=new Result();
        result.setCode(success);
        result.setData(data);
        return result;
    }

    public static Result error(String msg){
        Result result=new Result();
        result.setCode(error);
        result.setMsg(msg);
        return result;
    }
}
