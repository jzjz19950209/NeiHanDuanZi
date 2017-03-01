package com.example.qf.neihanduanzi.home.Model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by qf on 2016/11/2.
 */
public interface IDownLoadUserData {
    void getUserData(OnLoadDataListener onLoadDataListener);
}
