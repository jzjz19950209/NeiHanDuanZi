package com.example.qf.neihanduanzi.home.View.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.qf.neihanduanzi.home.View.Fragment_item.Details_Fragment;

import java.util.List;

/**
 * Created by qf on 2016/11/1.
 */
public class DetailsAdapter extends FragmentPagerAdapter {
    private List<Details_Fragment> details_fragments;

    public DetailsAdapter(FragmentManager fm, List<Details_Fragment> details_fragments) {
        super(fm);
        this.details_fragments = details_fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return details_fragments.get(position);
    }

    @Override
    public int getCount() {
        return details_fragments.size();
    }

}
