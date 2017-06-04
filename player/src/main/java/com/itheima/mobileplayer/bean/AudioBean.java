package com.itheima.mobileplayer.bean;

import android.database.Cursor;
import android.provider.MediaStore;

import com.itheima.mobileplayer.utils.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:音乐的JavaBean
 * M:数据模型
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/17 8:47
 */
public class AudioBean implements Serializable{
    private String data;
    private String title;
    private int    time;
    private long   size;

    public static ArrayList<AudioBean> getBeanFormCursor(Cursor cursor) {
        ArrayList<AudioBean> list = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0) {
            return list;
        }

        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            AudioBean bean = newInstanceFromCursor(cursor);
            list.add(bean);
        }

        return list;
    }

    public static AudioBean newInstanceFromCursor(Cursor cursor) {
        AudioBean bean = new AudioBean();
        if (cursor == null || cursor.getCount() == 0) {
            return bean;
        }
        String t = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
        bean.title = StringUtils.getTitle(t);
        bean.time = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
        bean.data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
        bean.size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));

        return bean;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "AudioBean{" +
                "data='" + data + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", size=" + size +
                '}';
    }
}
