package com.example.qf.neihanduanzi.home.presenter;

import android.view.View;
import android.widget.Toast;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.OkHttpUtils;
import com.example.qf.neihanduanzi.UserBean;
import com.example.qf.neihanduanzi.home.Model.IDownLoadCommentData;
import com.example.qf.neihanduanzi.home.Model.IDownLoadCommentImpl;
import com.example.qf.neihanduanzi.home.Model.OnLoadDataListener;
import com.example.qf.neihanduanzi.home.View.Fragment_item.Details_Fragment;
import com.example.qf.neihanduanzi.home.View.Fragment_item.IDetailsView;

import java.util.List;

/**
 * Created by qf on 2016/11/3.
 */
public class Home_comment_Presenter {
    private IDownLoadCommentData iDownLoadCommentData;
    private IDetailsView iDetailsView;
    private OnLoadDataListener onLoadDataListener=new OnLoadDataListener() {
        @Override
        public void onResponse(List<UserBean> list) {
            DataUtils.list_comment=list;
            iDetailsView.initCommentData(list);
            ((Details_Fragment) iDetailsView).details_refresh.setVisibility(View.GONE);
            if (list.size()==0){
                ((Details_Fragment) iDetailsView).noComment.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onFailure(String msg) {
            Toast.makeText((((Details_Fragment) iDetailsView)).getContext(), "数据请求失败", Toast.LENGTH_SHORT).show();
        }
    };

    public Home_comment_Presenter(IDetailsView iDetailsView) {
        this.iDetailsView = iDetailsView;
        iDownLoadCommentData=new IDownLoadCommentImpl();
    }
    public void initData(int id){
        iDownLoadCommentData.getCommentData(onLoadDataListener);
    }
}
