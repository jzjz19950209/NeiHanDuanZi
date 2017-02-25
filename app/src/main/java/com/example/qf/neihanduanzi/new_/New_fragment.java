package com.example.qf.neihanduanzi.new_;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.home.View.user_activity;

/**
 * Created by qf on 2016/10/13.
 */
public class New_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.new_fragment,container,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.login);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),user_activity.class));
            }
        });
        return view;
    }
}
