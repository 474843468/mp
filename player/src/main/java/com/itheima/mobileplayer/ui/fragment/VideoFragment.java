package com.itheima.mobileplayer.ui.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itheima.mobileplayer.R;
import com.itheima.mobileplayer.adapter.VideoListAdapter;
import com.itheima.mobileplayer.bean.VideoBean;
import com.itheima.mobileplayer.ui.activity.VitamioVideoPlayerActivity;

import java.util.ArrayList;

/**
 * Description:视频播放列表
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 10:06
 */
public class VideoFragment extends BaseFragment {

    private static final String TAG = "VideoFragment";
    private ListView lv;

    @Override
    public int getLayout() {
        return R.layout.fragment_video_list;
    }

    @Override
    public void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void initData() {
        //利用内容提供者查询多媒体数据库里的数据
        ContentResolver resolver = getActivity().getContentResolver();
        //查询的时候必须写_id列，不写报无效的参数异常
        final Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI,
                new String[]{Media._ID, Media.DATA, Media.TITLE, Media.DURATION, Media.SIZE}, null, null, null);

        //设置数据适配
        VideoListAdapter videoListAdapter = new VideoListAdapter(getActivity(), cursor);
        lv.setAdapter(videoListAdapter);

        //设置条目点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //                VideoBean bean = VideoBean.newInstanceFromCursor(cursor);
                //                intent.putExtra("bean",bean);

                ArrayList<VideoBean> list = VideoBean.getListFromCursor(cursor);

                Intent intent = new Intent();
//                intent.setClass(getActivity(), VideoPlayerActivity.class);
                intent.setClass(getActivity(), VitamioVideoPlayerActivity.class);
                intent.putExtra("list", list);
                intent.putExtra("pos", position);

                startActivity(intent);
            }
        });


        /*while(cursor.moveToNext()){
            VideoBean bean = VideoBean.newInstanceFromCursor(cursor);
            LogUtils.e(TAG, bean.toString());
        }*/
    }

    @Override
    public void initListener() {

    }
}
