package com.example.qf.neihanduanzi.home.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.OkHttpUtils;
import com.example.qf.neihanduanzi.UserBean;
import com.example.qf.neihanduanzi.home.Model.IDownLoadUserData;
import com.example.qf.neihanduanzi.home.Model.IDownLoadUserDataImpl;
import com.example.qf.neihanduanzi.home.Model.OnLoadDataListener;
import com.example.qf.neihanduanzi.home.View.Fragment_item.Duanzi;
import com.example.qf.neihanduanzi.home.View.Fragment_item.IDuanziView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/11/2.
 */
public class HomePresenter {
    private IDownLoadUserData iDownLoadUserData;
    private IDuanziView iDuanziView;
    private List<UserBean> list_userBean=new ArrayList<>();
    private List<UserBean> temp_list=new ArrayList<>();
    private OnLoadDataListener onLoadDataListener=new OnLoadDataListener() {
        @Override
        public void onResponse(List<UserBean> list) {
                temp_list.addAll(list_userBean);
                list_userBean.clear();
                list_userBean.addAll(list);
                list_userBean.addAll(temp_list);
                if (list_userBean.size()>40){
                    list_userBean=list_userBean.subList(0,40);
                }
                DataUtils.list_user =list_userBean;
                iDuanziView.initUserData(list_userBean);
           // ((Duanzi) iDuanziView).adapter.notifyDataSetChanged();
            ((Duanzi) iDuanziView).lv.setSelection(0);
            ((Duanzi) iDuanziView).swipeRefreshLayout.setRefreshing(false);
            ((Duanzi) iDuanziView).rotateAnimation.cancel();

            temp_list.clear();
        }

        @Override
        public void onFailure(String msg) {
            Toast.makeText(((Duanzi) iDuanziView).getContext(), "数据请求失败", Toast.LENGTH_SHORT).show();
            ((Duanzi) iDuanziView).swipeRefreshLayout.setRefreshing(false);
            ((Duanzi) iDuanziView).rotateAnimation.cancel();
        }
    };

    public HomePresenter(IDuanziView iDuanziView) {
        this.iDuanziView = iDuanziView;
        iDownLoadUserData=new IDownLoadUserDataImpl();
    }
    public void updateData(){
        iDownLoadUserData.getUserData(onLoadDataListener);
    }
}
