package com.example.qf.neihanduanzi.home.View.Fragment_item;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.VideoBean;
import com.example.qf.neihanduanzi.home.View.MyAdapter.VideoAdapter;
import com.example.qf.neihanduanzi.home.presenter.VideoPresenter;

import java.util.List;

/**
 * Created by qf on 2016/10/14.
 */
public class shipin extends Fragment implements IShipinView{
    public RotateAnimation rotateAnimation;
    private View view;
    private List<VideoBean> list;
    public SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private ImageView refresh;
    private VideoAdapter videoAdapter;
    private VideoPresenter presenter=new VideoPresenter(this);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rotateAnimation=new RotateAnimation(0,359,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(400);
        rotateAnimation.setRepeatMode(RotateAnimation.RESTART);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(RotateAnimation.INFINITE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view=inflater.inflate(R.layout.video_fragment,container,false);
        }else {
            return view;
        }
        init(view);
        refresh.setAnimation(rotateAnimation);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeRefreshLayout.setRefreshing(true);
                rotateAnimation.start();
                presenter.UpdateVideo();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rotateAnimation.start();
                presenter.UpdateVideo();
            }
        });
        presenter.UpdateVideo();

        return view;

    }
    private void init(View view){
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swLayout_video);
        listView= (ListView) view.findViewById(R.id.lv_video);
        refresh= (ImageView) view.findViewById(R.id.refresh_video);
    }

    @Override
    public void initVideoData(List<VideoBean> list) {
        videoAdapter=new VideoAdapter(list,getActivity());
        listView.setAdapter(videoAdapter);
    }

}
