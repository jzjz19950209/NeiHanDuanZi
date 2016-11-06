package com.example.qf.neihanduanzi.home.Model;



import com.example.qf.neihanduanzi.UserBean;

import java.util.List;

/**
 * Created by qf on 2016/10/14.
 */
public interface OnLoadDataListener {
     void onResponse(List<UserBean> list);
     void onFailure(String msg);
}
