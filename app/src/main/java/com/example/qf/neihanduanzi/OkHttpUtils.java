package com.example.qf.neihanduanzi;

import android.os.Handler;

import com.example.qf.neihanduanzi.home.Model.OnLoadDataListener;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qf on 2016/10/14.
 */
public class OkHttpUtils {
    private static OkHttpClient client=new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();
    private static Handler mHandler=new Handler();
    public static void getData(String httpUrl,final OnLoadDataListener onLoadDataListener){
        final Request request=new Request.Builder()
                .url(httpUrl).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onLoadDataListener.onFailure(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final List<UserBean> list=JsonParse.parseJsonList(response.body().string());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onLoadDataListener.onResponse(list);
                        }
                    });
                }
            }
        });
    }

    public static void getData_comment(String httpUrl, final OnLoadDataListener onLoadDataListener, String group_id){
        long id=Long.parseLong(group_id);
        final Request request=new Request.Builder()
                .url(String.format(httpUrl,id)).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onLoadDataListener.onFailure(e                      .getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String result=response.body().string();
                    final List<UserBean> list=JsonParse.parseJson2List(result);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onLoadDataListener.onResponse(list);
                        }
                    });
                }
            }
        });
    }
}
