package com.itheima.mobileplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.mobileplayer.ui.UiInterface;

/**
 * Description:整个项目fragment的父类
 * 1. 规范代码结构
 * 2. 提供公共的方法
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 9:04
 */
public abstract class BaseFragment extends Fragment implements UiInterface {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayout(), null);
        initView();
        initListener();
        initData();

        return mView;
    }

    /**
     * 加载fragment布局的控件
     * @param resId
     *         控件的id
     * @return 控件
     */
    public View findViewById(int resId) {
        return mView.findViewById(resId);
    }

}
