package com.itheima.mobileplayer.ui;

/**
 * Description:项目里UI的接口
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 9:06
 */
public interface UiInterface {

    /**
     * 加载布局
     */
    public   int getLayout();

    /**
     * 加载控件
     */
    public  void initView();

    /**
     * 初始化数据
     */
    public   void initData();

    /**
     * 初始化监听
     */
    public  void initListener();
}
