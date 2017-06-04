package com.itheima.mobileplayer.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.itheima.mobileplayer.ui.UiInterface;

/**
 * Description:整个项目的父类
 * 1. 规范代码结构  (模板设计模式)
 * 2. 提供公共的方法
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 8:51
 */
public abstract class BaseActivity extends FragmentActivity implements UiInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());
        initView();
        initListener();
        initData();
    }


}
