package edu.school21.cinema.model;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<Session> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Session> getResult() {
        return result;
    }

    public void setResult(List<Session> result) {
        this.result = result;
    }
}
