package com.itheima.mobileplayer.ui.activity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.itheima.mobileplayer.R;
import com.itheima.mobileplayer.adapter.PlayerListAdapter;
import com.itheima.mobileplayer.ui.fragment.AudioFragment;
import com.itheima.mobileplayer.ui.fragment.BaseFragment;
import com.itheima.mobileplayer.ui.fragment.VideoFragment;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    public static final int TABS_VIDEO = 0;
    public static final int TABS_AUDIO = 1;


    private ViewPager mViewPager;
    private TextView  tvAudio;
    private TextView  tvVideo;
    private View      mIndictor;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp);

        //标题栏
        tvAudio = (TextView) findViewById(R.id.tv_title_audio);
        tvVideo = (TextView) findViewById(R.id.tv_title_video);

        //指示器
        mIndictor = findViewById(R.id.indictor);
    }


    @Override
    public void initData() {
        //初始化标题栏
        updateTabs(TABS_VIDEO);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();

        //初始化指示器
        mIndictor.getLayoutParams().width = width / 2;
    }

    @Override
    public void initListener() {
        //标题栏
        tvVideo.setOnClickListener(this);
        tvAudio.setOnClickListener(this);


        //加载播放列表
        List<BaseFragment> list = new ArrayList<>();
        list.add(new VideoFragment());
        list.add(new AudioFragment());
        mViewPager.setAdapter(new PlayerListAdapter(getSupportFragmentManager(), list));

        //设置ViewPager滑动监听
        mViewPager.setOnPageChangeListener(new PageChangeListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title_video:
                switchTabs(TABS_VIDEO);
                break;
            case R.id.tv_title_audio:
                switchTabs(TABS_AUDIO);
                break;

            default:
                break;
        }
    }

    /**
     * 点击播放列表
     * @param tab
     *         选中的播放列表
     */
    private void switchTabs(int tab) {
        updateTabs(tab);
        //切换播放列表
        mViewPager.setCurrentItem(tab);

    }

    /**
     * 播放列表ViewPager滑动监听
     */
    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        //触发onOntouchEvent
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            LogUtils.e(TAG, "划过屏幕百分比：" + positionOffset);

            int width = mIndictor.getWidth();

            //2. 起始的位置 = 页面位置 * 指示器的宽度
            int startX  = position * width;

            //3. 移动的位置 = 划过屏幕的百分比 * 指示器的宽度
            float moveX = positionOffset * width;

            //1. 最终的位置 = 起始位置 + 移动位置
            int finalX =(int) (startX + moveX);

            ViewHelper.setTranslationX(mIndictor,finalX);
        }

        //选中某个页面调用
        @Override
        public void onPageSelected(int position) {
            updateTabs(position);
        }

        //页面滑动时调用
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     * 修改标题字体大小、颜色
     */
    private void updateTabs(int position) {
        int tab = TABS_VIDEO;
        if (position == tab) {
            //视频播放列表
            tvVideo.setTextColor(getResources().getColor(R.color.green));
            tvAudio.setTextColor(getResources().getColor(R.color.half_white));

            ViewPropertyAnimator.animate(tvVideo).scaleX(1.2f);
            ViewPropertyAnimator.animate(tvVideo).scaleY(1.2f);

            ViewPropertyAnimator.animate(tvAudio).scaleX(1f);
            ViewPropertyAnimator.animate(tvAudio).scaleY(1f);

        } else {
            //音乐播放列表
            tvVideo.setTextColor(getResources().getColor(R.color.half_white));
            tvAudio.setTextColor(getResources().getColor(R.color.green));

            ViewPropertyAnimator.animate(tvAudio).scaleX(1.2f);
            ViewPropertyAnimator.animate(tvAudio).scaleY(1.2f);

            ViewPropertyAnimator.animate(tvVideo).scaleX(1f);
            ViewPropertyAnimator.animate(tvVideo).scaleY(1f);
        }

    }
}
