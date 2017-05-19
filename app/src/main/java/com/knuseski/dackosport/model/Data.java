package com.knuseski.dackosport.model;

public class Data {

    private int day;

    private String header;

    private boolean isNew;
    private String bodyBig;
    private String bodySmall;

    public Data(int day, String header, boolean isNew, String bodyBig, String bodySmall) {
        this.day = day;
        this.header = header;
        this.isNew = isNew;
        this.bodyBig = bodyBig;
        this.bodySmall = bodySmall;
    }

    public int getDay() {
        return day;
    }

    public String getHeader() {
        return header;
    }

    public boolean isNew() {
        return isNew;
    }

    public String getBodyBig() {
        return bodyBig;
    }

    public String getBodySmall() {
        return bodySmall;
    }
}
