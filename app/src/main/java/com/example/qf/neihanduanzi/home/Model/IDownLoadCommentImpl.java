package com.example.qf.neihanduanzi.home.Model;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.OkHttpUtils;
import com.example.qf.neihanduanzi.UserBean;

import java.util.List;

/**
 * Created by qf on 2016/11/3.
 */
public class IDownLoadCommentImpl implements IDownLoadCommentData{

    @Override
    public void getCommentData(final OnLoadDataListener onLoadDataListener) {
        OkHttpUtils.getDZComment(DataUtils.DATA_COMMENT_URL, new OnLoadDataListener() {
            @Override
            public void onResponse(List<UserBean> list) {
                onLoadDataListener.onResponse(list);
            }

            @Override
            public void onFailure(String msg) {
                onLoadDataListener.onFailure(msg);
            }
        },DataUtils.group_id);

    }
}
