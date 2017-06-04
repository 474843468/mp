package com.itheima.mobileplayer.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.itheima.mobileplayer.R;

/**
 * Description:闪屏页
 * 1. 展示公司的logo
 * 2. 初始化数据
 * 3. 显示广告
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 9:36
 */
public class SplashActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
           //延迟3秒调到主页面
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this,MainActivity.class);
                startActivity(intent);

                //关闭
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0,3000);
    }

    @Override
    public void initListener() {

    }
}
