package com.itheima.mobileplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itheima.mobileplayer.ui.fragment.BaseFragment;

import java.util.List;

/**
 * Description:视频、音乐播放列表的数据适配器
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 9:59
 */
public class PlayerListAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mList;

    public PlayerListAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        mList = list;
    }

    /**
     * 显示条目
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    /**
     * 显示多少个条目
     */
    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }
}
