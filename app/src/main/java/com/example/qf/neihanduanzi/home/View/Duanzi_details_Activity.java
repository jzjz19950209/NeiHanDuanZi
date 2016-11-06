package com.example.qf.neihanduanzi.home.View;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.home.View.Fragment_item.Details_Fragment;
import com.example.qf.neihanduanzi.home.View.MyAdapter.DetailsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Duanzi_details_Activity extends AppCompatActivity{
    private List<Details_Fragment> details_fragments;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duanzi_details);
        viewPager= (ViewPager) findViewById(R.id.details_pager);
        details_fragments=new ArrayList<>();
        initFragment();
        DetailsAdapter adapter=new DetailsAdapter(getSupportFragmentManager(),details_fragments);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(DataUtils.clickPosition);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                DataUtils.clickPosition=position;
                DataUtils.group_id=DataUtils.list_user.get(DataUtils.clickPosition).getId();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initFragment(){
        Details_Fragment details_fragment_temp;
        for (int i = 0; i< DataUtils.list_user.size(); i++){
            details_fragment_temp=Details_Fragment.getInstance(i);
            details_fragments.add(details_fragment_temp);
        }
    }

    public void back(View view) {
        onBackPressed();
    }

}
