package com.example.qf.neihanduanzi;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.qf.neihanduanzi.home.Model.OnDownLoadVideoListener;
import com.example.qf.neihanduanzi.home.Model.OnLoadDataListener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();
    private static Handler mHandler = new Handler();
    //okhttp3请求
    public static void getData(String httpUrl, final OnLoadDataListener onLoadDataListener) {
        final Request request = new Request.Builder()
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
    //Volley请求
    public static void getDZData(String url,final OnLoadDataListener onLoadDataListener){
        StringRequest stringRequest=new StringRequest(com.android.volley.Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final List<UserBean> list=JsonParse.parseJsonList(response);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onLoadDataListener.onResponse(list);
                    }
                });
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        DataUtils.requestQueue.add(stringRequest);
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
                        onLoadDataListener.onFailure(e.getMessage());
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
    public static void getDZComment(String url, final OnLoadDataListener onLoadDataListener, String group_id){
        long id=Long.parseLong(group_id);
        StringRequest dz_comment=new StringRequest(com.android.volley.Request.Method.GET, String.format(url,id), new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s=null;
                try {
                    s = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                final List<UserBean> list=JsonParse.parseJson2List(s);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onLoadDataListener.onResponse(list);
                    }
                });
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
            DataUtils.requestQueue.add(dz_comment);
    }
    public static void getVideoData(String url, final OnDownLoadVideoListener onDownLoadVideoListener) {
            Request request=new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onDownLoadVideoListener.onFailure(e.getMessage());
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()){
                        String result = response.body().string();
                        final List<VideoBean> list=JsonParse.parseJson3List(result);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                onDownLoadVideoListener.onResponse(list);
                            }
                        });
                    }

                }
            });
    }
    public static void getVData(String url, final OnDownLoadVideoListener onDownLoadVideoListener){
        StringRequest getVideo=new StringRequest(com.android.volley.Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final List<VideoBean> list=JsonParse.parseJson3List(response);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onDownLoadVideoListener.onResponse(list);
                    }
                });
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
            DataUtils.requestQueue.add(getVideo);
    }
}
