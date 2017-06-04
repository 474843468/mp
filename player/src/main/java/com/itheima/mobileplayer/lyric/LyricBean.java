package com.itheima.mobileplayer.lyric;

/**
 * Description:歌词的JavaBean
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/18 10:48
 */
public class LyricBean {
    private int    startPoint;
    private String content;

    public LyricBean(int startPoint, String content) {
        this.startPoint = startPoint;
        this.content = content;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LyricBean{" +
                "startPoint=" + startPoint +
                ", content='" + content + '\'' +
                '}';
    }
}
