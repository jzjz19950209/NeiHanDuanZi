package com.example.qf.neihanduanzi.home.View.Fragment_item;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.UserBean;
import com.example.qf.neihanduanzi.home.Model.OnLoadDataListener;
import com.example.qf.neihanduanzi.home.View.Duanzi_details_Activity;
import com.example.qf.neihanduanzi.home.View.MyAdapter.MyDuanZiAdapter;
import com.example.qf.neihanduanzi.home.presenter.HomePresenter;

import java.util.List;

/**
 * Created by qf on 2016/10/14.
 */
public class Duanzi extends Fragment implements IDuanziView{

    public ListView lv;
    public SwipeRefreshLayout swipeRefreshLayout;
    private OnLoadDataListener callBack;
    private View view;
    private ImageView imageView;
    public RotateAnimation rotateAnimation;
    public  MyDuanZiAdapter adapter;
    private HomePresenter homePresenter=new HomePresenter(this);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view=getActivity().getLayoutInflater().inflate(R.layout.content,null);
//        imageView= (ImageView) view.findViewById(R.id.refresh);
        rotateAnimation=new RotateAnimation(0,359,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(400);
        rotateAnimation.setRepeatMode(RotateAnimation.RESTART);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(RotateAnimation.INFINITE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null) {
            view=inflater.inflate(R.layout.content,container,false);
        }else {
            return view;
        }
        imageView= (ImageView) view.findViewById(R.id.refresh);
        imageView.setAnimation(rotateAnimation);
        initView(view);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rotateAnimation.start();
                homePresenter.updateData();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeRefreshLayout.setRefreshing(true);
                rotateAnimation.start();
                homePresenter.updateData();
            }
        });
        return view;
    }

    private void initView(View view) {
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swLayout);
        lv= (ListView) view.findViewById(R.id.lv);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorTitle));
        homePresenter.updateData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataUtils.clickPosition=position;
                DataUtils.group_id=DataUtils.list_user.get(position).getId();
                Intent intent=new Intent(getContext(), Duanzi_details_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        lv.setSelection(DataUtils.clickPosition);
    }

    @Override
    public void initUserData(List<UserBean> list) {
        adapter=new MyDuanZiAdapter(list,getActivity());
        lv.setAdapter(adapter);
    }
}
