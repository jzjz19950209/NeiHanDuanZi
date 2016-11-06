package com.example.qf.neihanduanzi.home.View.MyAdapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qf.neihanduanzi.MyUtil;
import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.VideoBean;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by qf on 2016/11/5.
 */
public class VideoAdapter extends BaseAdapter{
    private List<VideoBean> list;
    private Context context;
    private LayoutInflater inflater;
    private MediaPlayer mediaPlayer;
    private int currentPosition=-1;

    public VideoAdapter(List<VideoBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {


            }
        });
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_shipin,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.userIcon= (ImageView) convertView.findViewById(R.id.icon_video);
            viewHolder.userName= (TextView) convertView.findViewById(R.id.username);
            viewHolder.categroy= (TextView) convertView.findViewById(R.id.category_name);
            viewHolder.content= (TextView) convertView.findViewById(R.id.content);
            viewHolder.up= (TextView) convertView.findViewById(R.id.up);
            viewHolder.down= (TextView) convertView.findViewById(R.id.down);
            viewHolder.hot= (TextView) convertView.findViewById(R.id.hot);
            viewHolder.zan= (TextView) convertView.findViewById(R.id.zan);
            viewHolder.commentIcon= (ImageView) convertView.findViewById(R.id.icon_comment);
            viewHolder.comment_content= (TextView) convertView.findViewById(R.id.content_comment);
            viewHolder.iv_video= (ImageView) convertView.findViewById(R.id.icon_video);
            viewHolder.surfaceView= (SurfaceView) convertView.findViewById(R.id.surface_view);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        VideoBean videoBean=list.get(position);
        Picasso.with(context).load(videoBean.getUserIcon()).into(viewHolder.userIcon);
        Picasso.with(context).load(videoBean.getCommentIcon()).into(viewHolder.commentIcon);
        int width=videoBean.getWidth();
        int height=videoBean.getHeight();
        ViewGroup.LayoutParams lp=viewHolder.iv_video.getLayoutParams();
        lp.width=width;
        lp.height=height;
        viewHolder.iv_video.requestLayout();
        viewHolder.surfaceView.setLayoutParams(lp);
        Picasso.with(context).load(videoBean.getVideoImage()).into(viewHolder.iv_video);
        viewHolder.userName.setText(videoBean.getUserName());
        viewHolder.content.setText(videoBean.getContent());
        viewHolder.comment_content.setText(videoBean.getCommentContent());
        viewHolder.up.setText(MyUtil.numberFormat(videoBean.getDigg_count()));
        viewHolder.down.setText(MyUtil.numberFormat(videoBean.getBury_count()));
        viewHolder.hot.setText(MyUtil.numberFormat(videoBean.getCommentCount()));
        viewHolder.zan.setText(MyUtil.numberFormat(videoBean.getZan()));

        Object tag = viewHolder.iv_video.getTag();
        if (tag!=null){
            Integer tag1 = (Integer) tag;
            if (tag1==currentPosition&&tag1!=position){
                mediaPlayer.stop();
                currentPosition=-1;
            }
        }

        viewHolder.iv_video.setTag(position);
        if (currentPosition==position){
            viewHolder.iv_video.setVisibility(View.INVISIBLE);
            viewHolder.surfaceView.setVisibility(View.VISIBLE);
            mediaPlayer.reset();
            mediaPlayer.setDisplay(viewHolder.surfaceView.getHolder());
            try {
                mediaPlayer.setDataSource(videoBean.getVideoUrl());
                mediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            viewHolder.iv_video.setVisibility(View.VISIBLE);
            viewHolder.surfaceView.setVisibility(View.INVISIBLE);
        }



        viewHolder.iv_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                Integer tag= (Integer) v.getTag();
                currentPosition=tag;
                notifyDataSetChanged();
            }
        });



        return convertView;
    }
    class ViewHolder{
        ImageView userIcon,iv_video,commentIcon;
        TextView userName,content,categroy,up,down,hot,zan,comment_content;
        SurfaceView surfaceView;

    }
}
