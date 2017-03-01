package com.example.qf.neihanduanzi;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.qf.neihanduanzi.explore.Explore_fragment;
import com.example.qf.neihanduanzi.home.View.Home_fragment;
import com.example.qf.neihanduanzi.message.Message_fragment;
import com.example.qf.neihanduanzi.new_.New_fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private LinearLayout line_home, line_explore, line_new, line_message;
    private List<Fragment> fragments;
    private Fragment currentFragment,fragment;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;
    private RadioButton home,explore,news,message;
    public RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        requestQueue=MyVolley.getMyVolley(this).getRequestQueue();
        DataUtils.requestQueue=requestQueue;
//        home.setImageResource(R.drawable.ic_tab_home_pressed);
//        tv1.setTextColor(getResources().getColor(R.color.colorCategroy));
//        transaction=getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.linearLayout,new Home_fragment()).commit();

    }

    private void setView() {
//        line_home = (LinearLayout) findViewById(R.id.line_home);
//        line_explore = (LinearLayout) findViewById(R.id.line_explore);
//        line_new = (LinearLayout) findViewById(R.id.line_new);
//        line_message = (LinearLayout) findViewById(R.id.line_message);
//        home= (ImageView) findViewById(R.id.home);
//        explore= (ImageView) findViewById(R.id.explore);
//        news= (ImageView) findViewById(R.id.news);
//        message= (ImageView) findViewById(R.id.message);
//        tv1= (TextView) findViewById(R.id.tv1);
//        tv2= (TextView) findViewById(R.id.tv2);
//        tv3= (TextView) findViewById(R.id.tv3);
//        tv4= (TextView) findViewById(R.id.tv4);
        radioGroup= (RadioGroup) findViewById(R.id.linearLayout1);
        home = (RadioButton) findViewById(R.id.line_home);
        explore= (RadioButton) findViewById(R.id.line_explore);
        news= (RadioButton) findViewById(R.id.line_new);
        message= (RadioButton) findViewById(R.id.line_message);
        initDrawable();
        fragments = new ArrayList<>();
        fragments.add(new Home_fragment());
        fragments.add(new Explore_fragment());
        fragments.add(new New_fragment());
        fragments.add(new Message_fragment());
        radioGroup.check(R.id.line_home);
        home.setTextColor(getResources().getColor(R.color.colorCategroy));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                initTextColor();
                switch (checkedId) {
                    case R.id.line_home:
                        fragment=fragments.get(0);
                        home.setTextColor(getResources().getColor(R.color.colorCategroy));
                        break;
                    case R.id.line_explore:
                        fragment=fragments.get(1);
                        explore.setTextColor(getResources().getColor(R.color.colorCategroy));
                        break;
                    case R.id.line_new:
                        fragment=fragments.get(2);
                        news.setTextColor(getResources().getColor(R.color.colorCategroy));
                        break;
                    case R.id.line_message:
                        fragment=fragments.get(3);
                        message.setTextColor(getResources().getColor(R.color.colorCategroy));
                        break;

                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (fragment.isAdded()) {
                    transaction.hide(currentFragment).show(fragment).commit();
                } else {
                    transaction.hide(currentFragment).add(R.id.linearLayout, fragment).commit();
                }
                currentFragment = fragment;
            }
        });
        currentFragment = fragments.get(0);
        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout, currentFragment).commit();
    }
    //设置radiobutton文字上面图片大小
    private void setDrawable(RadioButton radioButton,int id){
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0,15,70,85);
        radioButton.setTextColor(getResources().getColor(R.color.colorText));
        radioButton.setCompoundDrawables(null,drawable,null,null);
    }
    private void initDrawable(){
        setDrawable(home,R.drawable.home_bg);
        setDrawable(explore,R.drawable.explore_bg);
        setDrawable(news,R.drawable.new_bg);
        setDrawable(message,R.drawable.message_bg);
    }
    private void initTextColor(){
        home.setTextColor(getResources().getColor(R.color.colorText));
        explore.setTextColor(getResources().getColor(R.color.colorText));
        news.setTextColor(getResources().getColor(R.color.colorText));
        message.setTextColor(getResources().getColor(R.color.colorText));
    }


//    @Override
//    public void onClick(View v) {
//        tv1.setTextColor(getResources().getColor(R.color.colorText));
//        tv2.setTextColor(getResources().getColor(R.color.colorText));
//        tv3.setTextColor(getResources().getColor(R.color.colorText));
//        tv4.setTextColor(getResources().getColor(R.color.colorText));
//        home.setImageResource(R.drawable.ic_tab_home_normal_night);
//        explore.setImageResource(R.drawable.ic_tab_discovery_normal_night);
//        news.setImageResource(R.drawable.ic_tab_fresh_normal_night);
//        message.setImageResource(R.drawable.ic_tab_msg_normal_night);
//        FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
//        switch (v.getId()) {
//            case R.id.line_home:
//                home.setImageResource(R.drawable.ic_tab_home_pressed);
//                tv1.setTextColor(getResources().getColor(R.color.colorCategroy));
////                transaction1.replace(R.id.linearLayout,fragments.get(0));
//                fragment=new Home_fragment();
//                break;
//            case R.id.line_explore:
//                explore.setImageResource(R.drawable.ic_tab_discovery_pressed);
//                tv2.setTextColor(getResources().getColor(R.color.colorCategroy));
//                fragment=new Home_fragment();
// //               transaction1.replace(R.id.linearLayout,fragments.get(1));
//                break;
//            case R.id.line_new:
//                news.setImageResource(R.drawable.ic_tab_fresh_pressed);
//                tv3.setTextColor(getResources().getColor(R.color.colorCategroy));
//                fragment=new Home_fragment();
//  //              transaction1.replace(R.id.linearLayout,fragments.get(2));
//                break;
//            case R.id.line_message:
//                message.setImageResource(R.drawable.ic_tab_msg_pressed);
//                tv4.setTextColor(getResources().getColor(R.color.colorCategroy));
//                fragment=new Home_fragment();
//  //              transaction1.replace(R.id.linearLayout,fragments.get(3));
//                break;
//        }
//        if (fragment.isAdded()){
//            transaction1.hide(currentFragment).show(fragment).commit();
//        }else {
//            transaction1.hide(currentFragment).add(R.id.linearLayout,fragment).commit();
//        }
//           currentFragment=fragment;
//    }

}