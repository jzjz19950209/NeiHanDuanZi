package com.example.qf.neihanduanzi.home.Model;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.OkHttpUtils;
import com.example.qf.neihanduanzi.UserBean;

import java.util.List;

/**
 * Created by qf on 2016/11/2.
 */
public class IDownLoadUserDataImpl implements IDownLoadUserData {
    @Override
    public void getUserData(final OnLoadDataListener onLoadDataListener) {
        OkHttpUtils.getData(DataUtils.DATA_USER_URL, new OnLoadDataListener() {
            @Override
            public void onResponse(List<UserBean> list){
                onLoadDataListener.onResponse(list);
            }

            @Override
            public void onFailure(String msg) {
                onLoadDataListener.onFailure(msg);
            }
        });
    }
}
