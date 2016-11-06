package com.example.qf.neihanduanzi.home.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.home.View.Fragment_item.Duanzi;
import com.example.qf.neihanduanzi.home.View.Fragment_item.jinghua;
import com.example.qf.neihanduanzi.home.View.Fragment_item.shipin;
import com.example.qf.neihanduanzi.home.View.Fragment_item.tongcheng;
import com.example.qf.neihanduanzi.home.View.Fragment_item.tuijian;
import com.example.qf.neihanduanzi.home.View.Fragment_item.tupian;
import com.example.qf.neihanduanzi.home.View.Fragment_item.youxi;
import com.example.qf.neihanduanzi.home.View.MyAdapter.MyHomeItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/10/14.
 */
public class Home_fragment_item extends Fragment {
    private TabLayout tabLayout;
    private String[] titles=new String[]{"推荐","视频","图片","段子","精华","同城","游戏"};
    private ViewPager viewPager;
    private List<Fragment> fragments_home_item;
    private View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=getActivity().getLayoutInflater().inflate(R.layout.homepager_fragment_item,null);
        setHomeFragmentItem(view);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }


    private void setHomeFragmentItem(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager= (ViewPager) view.findViewById(R.id.viewpager_home_item);
        ViewPager viewPager_home = (ViewPager) view.findViewById(R.id.viewpager_home_item);
        setTitle_item();
        MyHomeItemAdapter myHomeItemAdapter = new MyHomeItemAdapter(getChildFragmentManager(), fragments_home_item, titles);
        viewPager_home.setAdapter(myHomeItemAdapter);
        //目前默认选择第4个
        viewPager_home.setCurrentItem(3);

        tabLayout.setupWithViewPager(viewPager_home);

    }

    public void setTitle_item() {
        fragments_home_item = new ArrayList<>();
        fragments_home_item.add(new tuijian());
        fragments_home_item.add(new shipin());
        fragments_home_item.add(new tupian());
        fragments_home_item.add(new Duanzi());
        fragments_home_item.add(new jinghua());
        fragments_home_item.add(new tongcheng());
        fragments_home_item.add(new youxi());
    }
}
