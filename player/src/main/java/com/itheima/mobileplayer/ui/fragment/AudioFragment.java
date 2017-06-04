package com.itheima.mobileplayer.ui.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itheima.mobileplayer.R;
import com.itheima.mobileplayer.adapter.AudioListAdapter;
import com.itheima.mobileplayer.bean.AudioBean;
import com.itheima.mobileplayer.ui.activity.AudioPlayerActivity;

import java.util.ArrayList;

/**
 * Description:音乐播放列表
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 10:04
 */
public class AudioFragment extends BaseFragment {
    private static final String TAG = "AudioFragment";
    private ListView lv;

    @Override
    public int getLayout() {
        return R.layout.fragment_audio_list;
    }

    @Override
    public void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void initData() {
        ContentResolver resolver = getActivity().getContentResolver();
        final Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{Media._ID,
                Media.SIZE, Media.DURATION, Media.DISPLAY_NAME, Media.DATA}, null, null, null);

        lv.setAdapter(new AudioListAdapter(getActivity(), cursor));

        //点击音乐的条
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<AudioBean> list = AudioBean.getBeanFormCursor(cursor);

                Intent intent = new Intent(getActivity(), AudioPlayerActivity.class);

                intent.putExtra("list",list);
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });

        //        while(cursor.moveToNext()){
        //            AudioBean audioBean = AudioBean.newInstanceFromCursor(cursor);
        //            LogUtils.e(TAG, audioBean.toString());
        //        }
    }

    @Override
    public void initListener() {

    }
}
