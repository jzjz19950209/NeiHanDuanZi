package com.example.qf.neihanduanzi.home.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.home.View.MyAdapter.MyHomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/10/13.
 */
public class Home_fragment extends Fragment{
    private List<String> titles;
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private List<Fragment> fragments_home;
    private View view;
    private ImageView login,edit;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=getActivity().getLayoutInflater().inflate(R.layout.homepager_fragment, null);
        setHomeFragment(view);
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
    private void setHomeFragment(View view){
        radioGroup= (RadioGroup) view.findViewById(R.id.radiogroup_home);
        viewPager= (ViewPager) view.findViewById(R.id.viewpager_home);
        login= (ImageView) view.findViewById(R.id.login);
        edit= (ImageView) view.findViewById(R.id.edit);
        setTitles();
        MyHomeAdapter myHomeAdapter=new MyHomeAdapter(getChildFragmentManager(),fragments_home);
        viewPager.setAdapter(myHomeAdapter);
        viewPager.setCurrentItem(0);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) radioGroup.getChildAt(position)).setChecked(true);
                
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.choiceness:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.attention:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),user_activity.class));
            }
        });
    }
    private void setTitles(){
        titles=new ArrayList<>();
        fragments_home=new ArrayList<>();
        titles.add("精选");
        titles.add("关注");
        fragments_home.add(new Home_fragment_item());
        fragments_home.add(new Fragment());
    }
}
