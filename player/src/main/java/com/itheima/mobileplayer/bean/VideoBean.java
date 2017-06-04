package com.itheima.mobileplayer.bean;

import android.database.Cursor;
import android.provider.MediaStore;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:视频的JavaBean
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 11:18
 */
public class VideoBean implements Serializable{

    private String title;
    private String data;
    private int    time;
    private long   size;

    /**
     * 从cursor中获取集合
     */
    public static ArrayList<VideoBean> getListFromCursor(Cursor cursor){
        ArrayList<VideoBean> list = new ArrayList<>();
        if (cursor == null || cursor.getCount()==0) {
              return list;
        }

        cursor.moveToPosition(-1);
        while(cursor.moveToNext()) {
            VideoBean bean = newInstanceFromCursor(cursor);
            list.add(bean);
        }
        return list;
    }


    /**
     * 从Cursor中获取JavaBean对象
     * @param cursor
     */
    public static VideoBean newInstanceFromCursor(Cursor cursor) {
        VideoBean bean = new VideoBean();

        if (cursor == null || cursor.getCount() == 0) {
            return bean;
        }

        bean.title = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE));
        bean.data = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        bean.time = cursor.getInt(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
        bean.size = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.SIZE));

        return bean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", time=" + time +
                ", size=" + size +
                '}';
    }
}
