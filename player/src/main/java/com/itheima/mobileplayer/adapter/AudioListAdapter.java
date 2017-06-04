package com.itheima.mobileplayer.adapter;

import android.content.Context;
import android.database.Cursor;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.itheima.mobileplayer.R;
import com.itheima.mobileplayer.bean.AudioBean;
import com.itheima.mobileplayer.utils.StringUtils;

/**
 * Description:音乐的播放列表
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/17 8:58
 */
public class AudioListAdapter extends CursorAdapter {

    private View view;

    public AudioListAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        view = View.inflate(context, R.layout.adapter_audio_list_item, null);
        view.setTag(new ViewHolder());
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        AudioBean audioBean = AudioBean.newInstanceFromCursor(cursor);

        holder.tvSize.setText(Formatter.formatFileSize(context,audioBean.getSize()));
        holder.tvTime.setText(StringUtils.formatTime(audioBean.getTime()));

        holder.tvTitle.setText(audioBean.getTitle());
    }

    class ViewHolder {
        TextView tvSize, tvTime, tvTitle;

        public ViewHolder() {
            tvSize = (TextView) view.findViewById(R.id.tv_size);
            tvTime = (TextView) view.findViewById(R.id.tv_time);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
